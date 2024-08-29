package Solution;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符
 * 而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * @author jinhaodong
 * @date 2024/8/26 17:46
 */
public class SubSequence392 {
    public static void main(String[] args) {
        String s = "aaa";
        String t = "bbaa";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        // s、t 获得 字符数组
        // 逐个判断
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // 前提判断
        if (sChars.length > tChars.length){
            return false;
        }

        int beginIndex = 0;
        for (int i = 0; i < sChars.length; i++){
            for (int j = beginIndex; j < tChars.length; j++){
                // 当前遍历过程，匹配到
                if(sChars[i] == tChars[j]){
                    int sCharRestLength = s.length() - i - 1;
                    int tCharRestLength = t.length() - j - 1;
                    if (sCharRestLength > tCharRestLength){
                        return false;
                    }
                    beginIndex = j+1;
                    break;
                }
                // 遍历完毕，未匹配到
                if (j == (tChars.length-1)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSubsequenceKMP(String s, String t){
        return false;
    }
}
