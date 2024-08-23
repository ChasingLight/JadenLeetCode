package jyyos.concurrency.sync.producerconsumer;

import jyyos.concurrency.sync.producerconsumer.spin.PCThread;

import java.io.FileReader;
import java.io.IOException;

/**
 * 验证-"生产者消费者"-并发执行的正确性
 * @author jinhaodong
 * @date 2024/8/19 14:36
 */
public class Check {

    public static void main(String[] args) {
        int count = 0;
        // 文件名
        String fileName = "D:\\JadenData\\jadenIdeaProject\\JadenLeetCode\\src\\jyyos\\concurrency\\sync\\producerConsumer\\output.txt";

        try (FileReader reader = new FileReader(fileName)) {
            int character;

            // 循环逐个读取字符，直到文件末尾
            while ((character = reader.read()) != -1) {
                // 将字符转换为 char 类型并打印
                char value = (char) character;
                if (value == '('){
                    count++;
                }else if(value == ')'){
                    count--;
                }
                // 验证
                if (count < 0 || count > PCThread.n){
                    System.out.printf("并发不正确，count为%d%n", count);
                    return;
                }
            }//end while

            System.out.printf("并发正确，count为%d%n", count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end method
}
