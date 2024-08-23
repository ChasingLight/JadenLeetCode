package jyyos.concurrency.sync.printfish.spin;

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
public class MainTest {

    public static void main(String[] args) {
        FishThread fishRunnable = new FishThread();

        int group = 3;
        for (int i = 0; i < group; i++) {
            Thread a = new Thread(fishRunnable, "a");
            Thread b = new Thread(fishRunnable, "b");
            Thread c = new Thread(fishRunnable, "c");
            a.start();
            b.start();
            c.start();
        }
    }//end main
}
