import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {4,6,1,2};
        int k = 2;
        System.out.println(maximumBeauty(nums, k));
    }

    /**
     * 1 <= nums.length <= 10^5
     * 0 <= nums[i], k <= 10^5
     */
    public static int maximumBeauty(int[] nums, int k) {
        int res = 1;
        int n = nums.length;
        // 排序 + 滑动窗口
        Arrays.sort(nums);
        int left = 0;
        for (int right = 0; right < n; right++) {
            while(nums[right] - nums[left] > 2*k){  // 伸伸手，拉不住（无交集）
                // 收缩左指针
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }//end method
}
