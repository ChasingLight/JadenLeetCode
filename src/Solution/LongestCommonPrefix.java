package Solution;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 *
 * @author jinhaodong
 * @date 2024/8/29 16:48
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        // 特殊情况考虑
        String[] strs1 = {""};
        String[] strs2 = {"", "", ""};
        String[] strs3 = {"jin", "hao", "don"};
        String[] strs4 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs4));
    }

    public static String longestCommonPrefix(String[] strs) {
        // 从字符串数组中，找到长度最小的字符
        String minStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if(strs[i].length() < minStr.length()){
                minStr = strs[i];
            }
        }
        // 一个一个比较，直接遍历不相同为止
        int i = 0;
        for (; i < minStr.length(); i++) {
            char currentChar = minStr.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                char c = strs[j].charAt(i);
                if (c != currentChar){
                    return minStr.substring(0, i);
                }
            }//end for
        }//end for
        return minStr;
    }//end method
}
