package Solution;

import java.util.HashMap;
import java.util.Map;

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
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
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

}
