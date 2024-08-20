package jyyos.concurrency.sync.fish.waitnotify;

/**
 * 一直等待，直到别人唤醒后继续执行。
 * 关键点：唤醒所有线程（notifyAll），再次判断同步条件（while(!condition)）。
 * @author jinhaodong
 * @date 2024/8/20 10:06
 */
public class FishThread2 implements Runnable{

    // 初始状态
    private String currentState = "G";

    private Object lock = new Object();

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if ("a".equals(name)){
            while (true){
                synchronized (lock){
                    while (!("G".equals(currentState) || "D".equals(currentState) || "B".equals(currentState))){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("<");
                    if ("G".equals(currentState)){
                        currentState = "A";
                    }else if ("D".equals(currentState)){
                        currentState = "E";
                    }else if ("B".equals(currentState)){
                        currentState = "C";
                    }
                    lock.notifyAll();
                }
            }
        }else if ("b".equals(name)){
            while (true){
                synchronized (lock){
                    while (!("G".equals(currentState) || "A".equals(currentState) || "E".equals(currentState))){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(">");
                    if ("G".equals(currentState)){
                        currentState = "D";
                    }else if ("A".equals(currentState)){
                        currentState = "B";
                    }else if ("E".equals(currentState)){
                        currentState = "F";
                    }
                    lock.notifyAll();
                }
            }
        }else if ("c".equals(name)){
            while (true){
                synchronized (lock){
                    while (!("C".equals(currentState) || "F".equals(currentState))){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("_");
                    currentState = "G";
                    lock.notifyAll();
                }
            }
        }
    }//end method
}//end class
