
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
     * 【闭区间-写法】
     * 返回最小的满足 nums[i] >= target 的下标 i。
     * 如果不存在（即 所有元素小于 target），返回 len(nums)。
     * @param nums  nums是非递减的，即 nums[i] <= nums[i+1]
     * @param target
     * @return
     */
    private static int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 闭区间
        while(left <= right){
            //int mid = (left + right) / 2;
            // 为避免溢出，上面代码优化为
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                // [left,mid] 均小于 target，染为红色
                left = mid + 1;  //下个待确认区间 [mid+1, right]
            }else{
                // [mid,right] 均大于等于 target，染为蓝色
                right = mid - 1;   //下个待确认区间 [left, mid-1]
            }
        }
        // 循环结束后，left > right 即 left = right + 1
        // 循环不变量
        // nums[left - 1] < target
        // nums[right + 1] >= target
        return right + 1;
    }//end method


    /**
     * 【左闭右开区间-写法】
     * 返回最小的满足 nums[i] >= target 的下标 i。
     * 如果不存在（即 所有元素小于 target），返回 len(nums)。
     * @param nums  nums是非递减的，即 nums[i] <= nums[i+1]
     * @param target
     * @return
     */
    private static int lowerBound2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // 左闭右开区间
        while(left < right){
            //int mid = (left + right) / 2;
            // 为避免溢出，上面代码优化为
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                // [left,mid] 均小于 target，染为红色
                left = mid + 1;  //下个待确认区间 [mid+1, right)
            }else{
                // [mid,right] 均大于等于 target，染为蓝色
                right = mid;   //下个待确认区间 [left, mid)
            }
        }
        // 循环结束后，left = right
        // 循环不变量
        // nums[left - 1] < target
        // nums[right] >= target
        return right;
    }//end method


    /**
     * 【开区间-写法】
     * 返回最小的满足 nums[i] >= target 的下标 i。
     * 如果不存在（即 所有元素小于 target），返回 len(nums)。
     * @param nums  nums是非递减的，即 nums[i] <= nums[i+1]
     * @param target
     * @return
     */
    private static int lowerBound3(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        // 开区间
        while(left + 1 < right){
            //int mid = (left + right) / 2;
            // 为避免溢出，上面代码优化为
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                // [left,mid] 均小于 target，染为红色
                left = mid;  //下个待确认区间 (mid, right)
            }else{
                // [mid,right] 均大于等于 target，染为蓝色
                right = mid;   //下个待确认区间 (left, mid)
            }
        }
        // 循环结束后，left < right 即 left + 1 = right
        // 循环不变量
        // nums[left] < target
        // nums[right] >= target
        return right;
    }//end method

}
