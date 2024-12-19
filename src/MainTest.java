import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(maximumCount(nums));
    }


    public static int maximumCount(int[] nums) {
        int neg = lowerBound(nums, 0);
        int pos = nums.length - lowerBound(nums, 1);
        return Math.max(neg, pos);
    }//end method

    /**
     * 闭区间-二分查找
     * 返回最小的满足 nums[i] >= target 的下标 i，如果所有数都 小于 target，返回数组的长度
     */
    private static int lowerBound(int[] nums, int target) {
        int left = 0;
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
