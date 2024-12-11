import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 7;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // 子数组乘积最小为 1
        if(k <= 1){
            return 0;
        }
        // 滑动窗口：移动右指针，收缩左指针
        int res = 0;
        int n = nums.length;
        int left = 0;
        int multiVal = 1;
        for (int right = 0; right < n; right++) {
            multiVal *= nums[right];
            // 收缩左指针
            while(multiVal >= k){
                multiVal /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }//end method

}
