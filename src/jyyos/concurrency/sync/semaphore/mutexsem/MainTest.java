package jyyos.concurrency.sync.semaphore.mutexsem;

import java.util.concurrent.Semaphore;

/**
 * @author jinhaodong
 * @date 2024/8/23 14:42
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        // 初始为0，直接阻塞main线程
        Semaphore join = new Semaphore(0);

        AddNum runnable = new AddNum(join);

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(runnable);
            thread.start();

            // main 线程，等待所有其他线程执行完毕后，再打印 sum 结果
            //thread.join();

            // 使用 semaphore 实现的 join
            join.acquire();
        }

        System.out.println(runnable.sum);
    }

}
