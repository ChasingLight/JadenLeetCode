package jyyos.concurrency.sync.printfish.waitnotify;

/**
 * 条件变量面试题
 * 描述：
 *      有三种线程：
 *      1> Ta若干，死循环打印 < ;
 *      2> Ta若干，死循环打印 > ;
 *      3> Ta若干，死循环打印 _ 。
 * 任务：
 *      对线程同步，使得屏幕打印出 <><_ 和  ><>_
 * Tips:
 *      使用条件变量，只要回答三个问题：
 *      打印 < 的条件？ 打印 > 的条件？ 打印 _ 的条件？
 *
 * 状态机：
 *           [A](<)---[B](>)---[C](<)
 * [G](_)---
 *          [D](>)---[E](<)---[F](>)
 *
 * @author jinhaodong
 * @date 2024/8/20 9:52
 */
public class MainTest2 {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        FishThread2 fishRunnable2 = new FishThread2(lock);

        // synchronized 是 阻塞锁
        synchronized (lock){
            System.out.println("---main 先获取锁---");
            Thread.sleep(3000);
            System.out.println("---main 释放锁---");
        }

        int group = 3;
        for (int i = 0; i < group; i++) {
            Thread a = new Thread(fishRunnable2, "a");
            Thread b = new Thread(fishRunnable2, "b");
            Thread c = new Thread(fishRunnable2, "c");
            a.start();
            b.start();
            c.start();
        }
    }//end main
}
