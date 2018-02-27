package Solution;

import java.util.*;

/**
 * Created by JadenOliver on 2018/1/15.
 */
public class SolutionHashTable {

    /**
     * 找到数组中单个频次的数字
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {

        int singelNum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int element: nums) {
            if (map.containsKey(element)){
                map.put(element, map.get(element)+1);
            }else{
                map.put(element, 1);
            }
        }

        for (Integer key :map.keySet()) {
            if (map.get(key) == 1)
                singelNum = key;
        }

        return singelNum;

    }//end method

    /**
     * 找到数组中单个频次的数字
     * 绝妙点：使用java中异或操作 ^
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }


    /**
     * 扩展
     * 交换两个变量的值，要求：不使用中间变量  绝妙点：使用java中异或操作 ^
     * @param a
     * @param b
     */
    public static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }


    /**
     * 找到字符串第一个惟一字符，对应下标
     * 思路：使用Hash Table思想解决
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {

        int[] counter = new int[26];

        //hash
        for (int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;
        }

        //find
        for (int i = 0; i < s.length(); i++){
            if(counter[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }



    /**
     * 找到字符串第一个惟一字符，对应下标
     * 思路：使用String的indexOf方法和lastIndexOf方法
     * @param s
     * @return
     */
    public static int firstUniqChar2(String s) {
        if (s == null || "".equals(s)){
            return -1;
        }

        int result = -1;
        for (char c : s.toCharArray()){
            if (s.indexOf(c) == s.lastIndexOf(c)){   //此种方法类似学生签到算法：String
                result = s.indexOf(c);
                break;
            }
        }

        return result;
    }

        /**
         * 判断字符串s和t是否为回文构词法
         * 思想：使用hash table去解决
         * @param s
         * @param t
         * @return
         */
        public static boolean isAnagram(String s, String t) {
            //特殊情况处理
            if (s.length() != t.length())
                return false;

            int[] counter = new int[26];

            //通过散列函数f(k) = k - 'a'，且k = ['a','z'],将k映射到counter数组上
            for(int i = 0; i < s.length(); i++){
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }

            for (int count : counter){
                if (count != 0)
                    return false;
            }

            return true;
        }

    /**
     * 判断字符串s和t是否为回文构词法
     * 使用Array.sort和equals两个方法处理
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    /**
     * 查询重复元素
     * 使用hash table思想来解决
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

}
