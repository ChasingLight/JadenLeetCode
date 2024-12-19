
import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] piles = {312884470};
        int h = 968709470;
        System.out.println(minEatingSpeed(piles, h));
    }


    /**
     * 1 <= piles.length <= 10^4
     * piles.length <= h <= 10^9
     * 1 <= piles[i] <= 10^9
     */
    public static int minEatingSpeed(int[] piles, int h) {
        // 确定二分的范围
        int left = 1;
        int right = 0;
        for(int val : piles) {
            right = Math.max(right, val);
        }
        // 查找最小吃香蕉速度
        // 闭区间写法
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(mid, piles, h)){
                // [mid,right] 均能吃完
                right = mid - 1;  // 下一个范围 [left, mid-1]
            }else{
                // [left,mid] 均不能吃完
                left = mid + 1;   // 下一个范围 []
            }
        }
        // 循环结束 left > right, 即 right + 1 = left
        // right + 1
        return right+1;
    }//end method

    private static boolean check(int mid, int[] piles, int h) {
        int sum = piles.length;
        for (int pile : piles) {
            sum += (pile - 1) / mid;
            if (sum > h) {
                return false;
            }
        }
        return true;
    }//end method

}
