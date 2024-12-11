import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        String s = "24489929009";
        System.out.println(longestSemiRepetitiveSubstring(s));
    }

    /**
     * 1 <= s.length <= 50
     * '0' <= s[i] <= '9'
     */
    public static int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        if (n == 1){
            return 1;
        }
        // 滑动窗口
        int res = 1;
        int left = 0;
        int pairs = 0;
        int[] pairValue = new int[2];
        for (int right = 1; right < n; right++) {
            // 判断相邻字符是否相等
            char preChar = s.charAt(right - 1);
            char c = s.charAt(right);
            if (preChar == c){
                pairValue[pairs++] = c;
            }
            while(pairs > 1){
                // 收缩左指针
                if(s.charAt(left) == pairValue[0] && s.charAt(left+1) == pairValue[0]){
                    pairs--;
                    pairValue[0] = pairValue[1];
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }//end method

}
