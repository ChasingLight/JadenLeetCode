package jyyos.concurrency.sync.producerConsumer.waitnotify;

/**
 * @author jinhaodong
 * @date 2024/8/19 10:50
 */
public class MainTest2 {

    public static void main(String[] args){
        PCThread2 runnable2 = new PCThread2();

        // 几对 生产者-消费者
        int pairs = 3;

        for (int i = 0; i < pairs; i++){
            Thread p = new Thread(runnable2, "p");
            p.start();
            Thread c = new Thread(runnable2, "c");
            c.start();
        }
    }//end main
}
