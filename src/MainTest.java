import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        // 滑动窗口：枚举右指针，收缩左指针
        int sum = 0;
        int left = 0;
        // 枚举右指针
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            // 因为数组元素均为正整数，此时往右枚举，子数组长度更大不符合
            while(sum >= target) {
                res = Math.min(res, right - left + 1);
                // 收缩左指针
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }//end method

}
