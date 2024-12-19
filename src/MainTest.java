import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }


    public static int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = lowerBound(nums, target+1) - 1;
        return new int[]{start, end};
    }//end method

    /**
     * 闭区间-二分查找
     * 返回最小的满足 nums[i] >= target 的下标 i
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
