import java.util.Arrays;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] spells = {3,1,2};
        int[] potions = {8,5,8};
        int success = 16;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }


    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] res = new int[n];
        // potions 升序排序
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int x = spells[i];
            // 向上取整
            int target = (int) Math.ceil((double) success / x);
            int index = lowerBound(potions, target);
            res[i] = (index == potions.length) ? 0 : (potions.length - index);
        }
        return res;
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
