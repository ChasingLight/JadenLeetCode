package mainTest;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by JadenOliver on 2018/2/7.
 */
public class TreeMapSortTest {

    public static void main(String[] args) {
        Map<String, String> map3 = new TreeMap<>();  //默认TreeMap升序排列

        map3.put("v","v");
        map3.put("o","o");
        map3.put("a","a");

        for(String key : map3.keySet()){
            System.out.println(key + "---" + map3.get(key));
        }


        Map<String, String> map4 = new TreeMap<>(new Comparator<String>() {  //默认是升序，如何降序
            /*
            * int compare(Object o1, Object o2) 返回一个基本类型的整型，
            * 返回负数表示：o1 小于o2，
            * 返回0 表示：o1和o2相等，
            * 返回正数表示：o1大于o2。
            */
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        map4.put("v","v");
        map4.put("o","o");
        map4.put("a","a");

        for(String key : map4.keySet()){
            System.out.println(key + "---" + map4.get(key));
        }



        TreeMap<Integer,Integer> map1 = new TreeMap<>();  //默认的TreeMap升序排列
        map1.put(1,1);
        map1.put(2,2);
        map1.put(7,7);
        map1.put(5,5);
        System.out.println("map1="+map1);

        /*
        * int compare(Object o1, Object o2) 返回一个基本类型的整型，
        * 返回负数表示：o1 小于o2，
        * 返回0 表示：o1和o2相等，
        * 返回正数表示：o1大于o2。
        */
        TreeMap<Integer,Integer> map2= new TreeMap<>((a,b) -> b.compareTo(a));
        map2.put(1,1);
        map2.put(2,2);
        map2.put(7,7);
        map2.put(5,5);
        System.out.println("Map2="+map2);



    }


}
