import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {5,5,5,5,5,5,5};
        int k = 4;
        System.out.println(maxSubarrayLength(nums, k));
    }

    /**
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     * 1 <= k <= nums.length
     */
    public static int maxSubarrayLength(int[] nums, int k) {
        int res = 1;
        int n = nums.length;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            int x = nums[right];
            map.put(x, map.getOrDefault(x, 0) + 1);
            // 收缩左指针
            while(map.get(x) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }//end method

}
