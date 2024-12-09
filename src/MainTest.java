import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 升序排序
        Arrays.sort(nums);
        // 三数之和
        int n = nums.length;
        for (int i = 0; i <= n - 3; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i-1]){
                continue;
            }
            // 剪枝
            if (x + nums[i+1] +nums[i+2] > 0){
                break;
            }
            if (x + nums[n-2] + nums[n-1] < 0){
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            // 两数之和
            while(j < k){
                int value = x + nums[j] + nums[k];
                if(value > 0){
                    k--;
                }else if (value < 0){
                    j++;
                }else{
                    res.add(Arrays.asList(x, nums[j], nums[k]));
                    j++;
                    while (j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    k--;
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                }
            }//end while
        }
        return res;
    }//end method
}
