package jyyos.concurrency.sync.producerconsumer.spin;

/**
 * @author jinhaodong
 * @date 2024/8/19 10:50
 */
public class MainTest {

    public static void main(String[] args){
        PCThread runnable = new PCThread();

        // 几对 生产者-消费者
        int pairs = 3;

        for (int i = 0; i < pairs; i++){
            Thread p = new Thread(runnable);
            p.setName("p");
            p.start();

            Thread c = new Thread(runnable);
            c.setName("c");
            c.start();
        }
    }//end main
}
