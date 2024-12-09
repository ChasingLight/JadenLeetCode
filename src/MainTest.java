import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] numbers = {-1,0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        // 相向双指针
        int n = numbers.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int value = numbers[i] + numbers[j];
            if (value > target) {
                j--;
            }else if (value < target) {
                i++;
            }else{
                res[0] = ++i;
                res[1] = ++j;
                break;
            }
        }
        return res;
    }
}
