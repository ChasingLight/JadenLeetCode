import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] temperatures = {1,4,3,5,5,2,3,6};
        System.out.println( Arrays.toString(dailyTemperatures(temperatures)) );
    }

    /**
     * 每日温度
     * @param temperatures  数组长度取值范围 [1,10^5]
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        /*// 从右往左
        for (int i = n - 1; i >= 0; i--) {
            // 当前值大于等于栈顶值，栈顶值出栈
            while(!stack.isEmpty()
                    && temperatures[i] >= temperatures[stack.peek()] ) {
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }*/

        // 从左往右
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }//end method

}
