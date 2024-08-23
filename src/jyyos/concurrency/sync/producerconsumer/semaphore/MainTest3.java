package jyyos.concurrency.sync.producerconsumer.semaphore;

/**
 * 使用信号量，实现生产者消费者
 * @author jinhaodong
 * @date 2024/8/23 14:23
 */
public class MainTest3 {
    public static void main(String[] args) {
        PCThread3 semRunnable = new PCThread3();

        // 几对 生产者-消费者
        int pairs = 3;

        for (int i = 0; i < pairs; i++){
            Thread p = new Thread(semRunnable, "p");
            p.start();

            Thread c = new Thread(semRunnable, "c");
            c.start();
        }
    }
}
