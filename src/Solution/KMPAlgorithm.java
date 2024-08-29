package Solution;

/**
 * @author jinhaodong
 * @date 2024/8/27 9:46
 */
public class KMPAlgorithm {

    // 方法：计算部分匹配表（LPS数组）
    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0; // 当前最长前缀后缀的长度
        int i = 1;

        lps[0] = 0; // lps[0] 总是 0

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // 方法：使用 KMP 算法在文本中查找模式
    public static void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPSArray(pattern);

        int i = 0; // text的索引
        int j = 0; // pattern的索引

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("找到匹配，起始位置：" + (i - j));
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    // 主方法：测试KMP算法
    public static void main(String[] args) {
        String text = "BBC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";
        KMPSearch(text, pattern);
    }
}

