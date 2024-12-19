import java.util.Arrays;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {0,1,7,4,4,5};
        int lower = 3;
        int upper = 6;
        System.out.println(countFairPairs(nums, lower, upper));
    }


    /**
     * 1 <= nums.length <= 10^5
     * nums.length == n
     * -10^9 <= nums[i] <= 10^9
     * -10^9 <= lower <= upper <= 10^9
     */
    public static long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0L;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= n-2; i++) {
            int l = lowerBound(nums, i+1, lower - nums[i]);
            int r = lowerBound(nums, i+1, upper - nums[i] + 1);
            res += (r - 1) - l + 1;
        }
        return res;
    }//end method

    /**
     * 闭区间-二分查找
     * 返回最小的满足 nums[i] >= target 的下标 i，如果所有数都 小于 target，返回数组的长度
     */
    private static int lowerBound(int[] nums, int left, int target) {
        int right = nums.length - 1;
        while (left <= right) {
            // 循环不变量：
            // nums[left-1] < target
            // nums[right+1] >= target
            int mid = left + (right - left) / 2;    // 向下取整
            if (nums[mid] < target) {
                left = mid + 1;     //[mid+1, right]
            }else{
                right = mid - 1;    //[left, mid-1]
            }
        }
        // 循环结束 left = right + 1
        return right+1;
    }//end method

}
