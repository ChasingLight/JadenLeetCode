
import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] time = {1935,5727103};
        int totalTrips = 6189436;
        System.out.println(minimumTime(time, totalTrips));
    }


    /**
     * 1 <= time.length <= 10^5
     * 1 <= time[i], totalTrips <= 10^7
     */
    public static long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        // 确定二分的范围
        long left = 1;
        int maxTime = 0;
        for (int val : time) {
            maxTime = Math.max(maxTime, val);
        }
        long right = ((long) Math.ceil((double) totalTrips / n)) * maxTime;
        // 二分查找-闭区间
        while(left <= right){
            // 向下取整
            long mid = (left + right) / 2;
            if(check(mid, time, totalTrips)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right+1;
    }//end method

    private static boolean check(long mid, int[] time, int totalTrips) {
        long sum = 0;
        for (int val : time) {
            sum += mid / val;
            if (sum >= totalTrips) {
                return true;
            }
        }
        return false;
    }//end method

}
