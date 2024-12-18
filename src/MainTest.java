import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));

        char c1 = 'a';
        char c2 = 'z';
        char c3 = 'A';
        char c4 = 'Z';
        System.out.println(c1 - 97);
        System.out.println(c2 - 122);
        System.out.println(c3 - 65);
        System.out.println(c4 - 90);
    }

    /**
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^4
     * 1 <= x <= 10^9
     */
    public static String minWindow(String s, String t) {
        // 窗口条件
        Map<Character, Integer> tMap = new HashMap<>(52);
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        // 滑动窗口
        String res = "";
        int left = 0;
        int n = s.length();
        Map<Character, Integer> sMap = new HashMap<>(52);
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            // 满足 到 不满足
            while(meetRequire(sMap, tMap)){
                if (res.equals("")){
                    res = s.substring(left, right+1);
                }else{
                   res = (right-left+1) < res.length() ? s.substring(left, right+1) : res;
                }
                // 收缩左指针  收缩到位
                sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                left++;
            }//end while
        }
        // 最小窗口，截取 left、right
        return res;
    }//end method

        static boolean meetRequire(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
            for (Character c :  tMap.keySet()){
                int tVal = tMap.get(c);
                Integer sVal = sMap.getOrDefault(c, 0);
                if (sVal < tVal) {
                    return false;
                }
            }
            return true;
        }//end method

}
