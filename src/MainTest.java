import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }


    public static int maxArea(int[] height) {
        int res = 0;
        int n = height.length;
        int i = 0, j = n - 1;
        while(i < j){
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }

}
