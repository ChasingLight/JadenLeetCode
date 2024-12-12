import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {1,4,2,1};
        int k = 3;
        System.out.println(countSubarrays(nums, k));
    }

    /**
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     * 1 <= k <= 10^5
     */
    public static long countSubarrays(int[] nums, int k) {
        long res = 0;
        int n = nums.length;
        int maxNum = nums[0];
        // 找到数组的最大值
        for(int num : nums){
            maxNum = Math.max(maxNum, num);
        }
        // 滑动窗口
        int left;
        int currentTimes;
        int times = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == maxNum) {
                times++;
            }
            // 收缩左指针
            if(times >= k){
                left = 0;
                currentTimes = times;
                while(currentTimes >= k){
                    res++;
                    if (nums[left++] == maxNum) {
                        currentTimes--;
                    }
                }
            }//end if
        }
        return res;
    }//end method
}
