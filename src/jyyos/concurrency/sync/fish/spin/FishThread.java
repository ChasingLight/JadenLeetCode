package jyyos.concurrency.sync.fish.spin;

/**
 * 自旋等待，直到条件满足
 * @author jinhaodong
 * @date 2024/8/20 10:06
 */
public class FishThread implements Runnable{

    // 初始状态
    private String currentState = "G";

    private Object lock = new Object();

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if ("a".equals(name)){
            while (true){
                synchronized (lock){
                    boolean aCanPrint = ("G".equals(currentState) || "D".equals(currentState) || "B".equals(currentState));
                    if (!aCanPrint){
                        continue;
                    }
                    System.out.print("<");
                    if ("G".equals(currentState)){
                        currentState = "A";
                    }else if ("D".equals(currentState)){
                        currentState = "E";
                    }else if ("B".equals(currentState)){
                        currentState = "C";
                    }
                }
            }
        }else if ("b".equals(name)){
            while (true){
                synchronized (lock){
                    boolean bCanPrint = ("G".equals(currentState) || "A".equals(currentState) || "E".equals(currentState));
                    if (!bCanPrint){
                        continue;
                    }
                    System.out.print(">");
                    if ("G".equals(currentState)){
                        currentState = "D";
                    }else if ("A".equals(currentState)){
                        currentState = "B";
                    }else if ("E".equals(currentState)){
                        currentState = "F";
                    }
                }
            }
        }else if ("c".equals(name)){
            while (true){
                synchronized (lock){
                    boolean cCanPrint = ("C".equals(currentState) || "F".equals(currentState));
                    if (!cCanPrint){
                        continue;
                    }
                    System.out.print("_");
                    currentState = "G";
                }
            }
        }
    }//end method
}//end class
