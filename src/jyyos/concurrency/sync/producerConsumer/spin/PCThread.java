package jyyos.concurrency.sync.producerConsumer.spin;

/**
 * 生产者消费者（带缓冲区）---自旋等待
 * 缺点：可能使得 CPU 资源浪费
 * @author jinhaodong
 * @date 2024/8/19 10:39
 */
public class PCThread implements Runnable{

    // 缓冲区的长度
    public final static int n = 5;
    // 缓冲区实时深度
    private int depth = 0;
    // 锁
    private final Object lock = new Object();

    public void run() {
        String name = Thread.currentThread().getName();
        if ("p".equals(name)){
            while (true){
                synchronized (lock){
                    if (!(depth < n)){
                        continue;
                    }
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("(");
                    depth++;
                }
            }
        }else if("c".equals(name)){
            while (true){
                synchronized (lock){
                    if (!(depth > 0)){
                        continue;
                    }
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(")");
                    depth--;
                }
            }
        }
    }//end method

}//end class
