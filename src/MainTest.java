import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length();
        int left = 0;
        String currStr;
        for (int right = 0; right < n; right++) {
            currStr = s.substring(left, right + 1);
            while(hasRepeatedChar(currStr)) {
                // 收缩左指针
                currStr = s.substring(++left, right + 1);
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }//end method

    private static boolean hasRepeatedChar(String s) {
        int n = s.length();
        if (1 == n){
            return false;
        }else{
            char c = s.charAt(n - 1);
            String lastStr = s.substring(0, n - 1);
            return lastStr.indexOf(c) != -1;
        }
    }

}
