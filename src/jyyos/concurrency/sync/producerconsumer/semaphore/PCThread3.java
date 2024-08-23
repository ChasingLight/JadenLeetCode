package jyyos.concurrency.sync.producerconsumer.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量，实现生产者消费者
 * 代码优雅、简洁
 * @author jinhaodong
 * @date 2024/8/23 14:11
 */
public class PCThread3 implements Runnable{

    // 初始代表，有 5个空槽可以被生产占用，0个填充被消费。
    // 空槽信号量
    private Semaphore empty = new Semaphore(5);
    // 填充信号量
    private Semaphore fill = new Semaphore(0);

    @Override
    public void run() {
        try{
            String name = Thread.currentThread().getName();
            if ("p".equals(name)){
                while(true){
                    empty.acquire();
                    System.out.print("(");
                    fill.release();
                }
            }else if("c".equals(name)){
                while (true){
                    fill.acquire();
                    System.out.print(")");
                    empty.release();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }//end method
}
