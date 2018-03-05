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
         * 判断字符串s和t是否为回文构词法  eg："eat" 和 "tea"两个词就是回文构词法。
         * 总结回文构词特点：1.首先两个词长度相同； 2.再者两个词解析为字母集合，两个集合相同。
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
     * 判断整数数组，是否含有重复元素
     * 解决方案：使用Set集合类
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 0)   return false;

        //array -> list
        List<Integer> list = new ArrayList<>();
        for (int i=0; i < nums.length; i++){
            list.add(nums[i]);
        }

        //get size1
        int size1 = list.size();

        //list -> set
        Set set = new HashSet(list);

        //get size2
        int size2 = set.size();

        return !(size1 == size2);
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

    /**
     * 求两个int数组交集：包含重复元素
     * @param nums1   [1, 2, 2, 1]
     * @param nums2   [2, 2]
     * @return [2, 2]
     */
    public static int[] intersectII(int[] nums1, int[] nums2) {

        //1.sort
        Arrays.sort(nums1);   //[1, 1, 2, 2, 2]
        Arrays.sort(nums2);   //[2, 3]

        //2.compare and find
        int pnt1 = 0;  //指针下标1
        int pnt2 = 0;  //指针下标2

        ArrayList<Integer> myList = new ArrayList<Integer>();
        while( (pnt1 < nums1.length) && (pnt2 < nums2.length) ){
            if(nums1[pnt1]<nums2[pnt2]){
                pnt1++;
            }
            else{
                if(nums1[pnt1]>nums2[pnt2]){
                    pnt2++;
                }
                else{
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }

        //3.list -> array
        int[] res = new int[myList.size()];
        for(int i = 0; i<res.length; i++){
            res[i] = (Integer)myList.get(i);
        }
        return res;
    }

    /**
     * 求两个int数组交集：不包含重复元素
     * @param nums1   [1, 2, 2, 1]
     * @param nums2   [2, 2]
     * @return [2]
     */
    public static int[] intersectI(int[] nums1, int[] nums2) {

        //1.sort
        Arrays.sort(nums1);   //[1, 1, 2, 2, 2]
        Arrays.sort(nums2);   //[2, 3]

        //2.compare and find
        int pnt1 = 0;  //指针下标1
        int pnt2 = 0;  //指针下标2

        ArrayList<Integer> myList = new ArrayList<Integer>();
        while( (pnt1 < nums1.length) && (pnt2 < nums2.length) ){
            if(nums1[pnt1]<nums2[pnt2]){
                pnt1++;
            }
            else{
                if(nums1[pnt1]>nums2[pnt2]){
                    pnt2++;
                }
                else{
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }

        //3.remove Duplicate
        Set<Integer> set = new HashSet<>();
        set.addAll(myList);
        myList.clear();
        myList.addAll(set);

        //4.list -> array
        int[] res = new int[myList.size()];
        for(int i = 0; i<res.length; i++){
            res[i] = (Integer)myList.get(i);
        }
        return res;
    }

    /**
     * 给定一个非负数n，求小于n范围内，有多少个质数。
     * 质数:一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数.
     *
     * 特别注意：这种算法，时间复杂度过高，导致算法运行时间过长。
     * @param n
     * @return
     */
    public static int countPrimes(int n) {

        int count = 0;

        //切分范围
        if (n <= 1){  //[0,1]
            return count;
        }else{  //大于1
            for(int num=2; num < n; num++){
                if(isPrimes(num)){
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 判断输入的自然数是否为质数
     * @param num
     * @return
     */
    public static boolean isPrimes(int num){
        for (int i=2; i <= num/2; i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }

}
