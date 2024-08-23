package jyyos.concurrency.sync.producerconsumer.waitnotify;

/**
 * 生产者消费者（带缓冲区）---wait/notifyAll机制
 * @author jinhaodong
 * @date 2024/8/19 10:39
 */
public class PCThread2 implements Runnable{

    // 缓冲区的长度
    public final static int n = 5;
    // 缓冲区实时深度
    private int depth = 0;
    // 锁
    private final Object lock = new Object();


    public void run() {
        String name = Thread.currentThread().getName();
        if ("p".equals(name)){
            try{
                while (true){
                    synchronized (lock){
                        while (!(depth < n)){
                            lock.wait();
                        }
                        Thread.sleep(4);
                        System.out.print("(");
                        depth++;
                        lock.notifyAll();
                    }
                }//end while
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if("c".equals(name)){
            try{
                while (true){
                    synchronized (lock){
                        while (!(depth > 0)){
                            lock.wait();
                        }
                        try {
                            Thread.sleep(4);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(")");
                        depth--;
                        lock.notifyAll();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }//end method

}//end class
