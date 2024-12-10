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
        // 前缀最大高度
        int[] preMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i-1], height[i]);
        }
        // 后缀最大高度
        int[] sufMax = new int[n];
        sufMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i+1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return res;
    }//end method


}
