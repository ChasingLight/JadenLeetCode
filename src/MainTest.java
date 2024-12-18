import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {2,4};
        int x = 6;
        System.out.println(minOperations(nums, x));

        char c1 = 'a';
        char c2 = 'z';
        char c3 = 'A';
        char c4 = 'Z';
        nums[c1] = 1;
        System.out.println(c1 - 97);
        System.out.println(c2 - 122);
        System.out.println(c3 - 65);
        System.out.println(c4 - 90);
    }

    /**
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^4
     * 1 <= x <= 10^9
     */
    public static int minOperations(int[] nums, int x) {
        int res = -1;
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // 剪枝：全部移除也无法满足要求
        if (totalSum < x) {
            return -1;
        }
        // 极限情况: totalSum == x, target = 0 符合
        int target = totalSum - x;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            // 不满足条件 到 满足条件
            while(sum > target) {
                // 收缩左指针
                sum -= nums[left++];
            }
            if (sum == target) {
                res = Math.max(res, right - left + 1);
            }
        }
        return res == -1 ? -1 : n-res;
    }//end method
}
