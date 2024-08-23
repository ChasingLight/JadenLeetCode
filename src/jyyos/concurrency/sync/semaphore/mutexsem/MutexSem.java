package jyyos.concurrency.sync.semaphore.mutexsem;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量 实现 互斥锁
 *    信号量可以看做是互斥锁的一个 “推广”
 * @author jinhaodong
 * @date 2024/8/23 14:30
 */
public class MutexSem {

    private static Semaphore mutex = new Semaphore(1);

    public static void lock() throws InterruptedException {
        // permits - 1
        mutex.acquire();
    }

    public static void unlock(){
        // permits + 1
        mutex.release();
    }

}//end class
