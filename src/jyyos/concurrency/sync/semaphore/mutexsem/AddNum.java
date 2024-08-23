package jyyos.concurrency.sync.semaphore.mutexsem;

import java.util.concurrent.Semaphore;

/**
 * @author jinhaodong
 * @date 2024/8/23 14:36
 */
public class AddNum implements Runnable{
    public int sum = 0;

    private Semaphore join;

    public AddNum(Semaphore join) {
        this.join = join;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try {
                MutexSem.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum++;
            MutexSem.unlock();
        }
        // 线程执行完毕，release join sem
        join.release();
    }//end run
}
