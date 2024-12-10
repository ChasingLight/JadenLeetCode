import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }


    public static int trap(int[] height) {
        int res = 0;
        int n = height.length;
        // 相向双指针
        int left = 0, right = n -1;
        int preMax = 0;
        int sufMax = 0;
        while(left < right){
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if(preMax < sufMax){
                res += preMax - height[left++];
            }else{
                res += sufMax - height[right--];
            }
        }
        return res;
    }//end method


}
