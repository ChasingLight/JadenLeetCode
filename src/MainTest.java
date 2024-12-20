
import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {3,7,1,6};
        System.out.println(minimizeArrayValue(nums));
    }


    /**
     * n == nums.length
     * 2 <= n <= 10^5
     * 0 <= nums[i] <= 10^9
     */
    public static int minimizeArrayValue(int[] nums) {
        // 确定二分范围
        int left = 0;
        int right = 0;
        for(int val : nums){
            right = Math.max(right, val);
        }
        // 具有单调性，二分查找
        while(left <= right) {
            int mid = (left + right) / 2;
            //System.out.printf("left: %d, right: %d, mid: %d\n", left, right, mid);
            if(check(nums, mid)) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        // 循环不变量 left - 1、right + 1
        // 结束循环时，left > right，即 right + 1 = left
        return right+1;
    }//end method

    private static boolean check(int[] nums, int limit) {
        long extra = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i] + extra > limit){
                extra = nums[i] + extra - limit;
            }else{
                extra = 0;
            }
        }
        return (nums[0] + extra) <= limit;
    }//end method

}
