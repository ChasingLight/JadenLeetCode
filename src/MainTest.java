import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {10,15,1,1,20,1};
        int k = 5;
        System.out.println(countSubarrays(nums, k));
    }

    /**
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     * 1 <= k <= 10^15
     */
    public static long countSubarrays(int[] nums, long k) {
        // 极限考虑 nums 只有一个元素 10，k为5，适用
        long res = 0L;
        int n = nums.length;
        int left = 0;
        long sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while(sum * (right - left + 1)  >= k){
                // 收缩左指针
                sum -= nums[left++];
            }
            res += (right - left + 1);
        }
        return res;
    }//end method
}
