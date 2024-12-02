import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] arr = {2,1,3};
        int n = arr.length;
        // 2,0,1
        // 对数组下标（即-下标对应的值）进行排序，不改变原数组的顺序
        // 方法1：Arrays.sort
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i,j) -> arr[j]-arr[i]);
        System.out.println(Arrays.toString(ids));

        // 方法2：Map => index,value
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, arr[i]);
        }
        List<Integer> res = map.keySet().stream().sorted((i, j) -> map.get(j) - map.get(i)).collect(Collectors.toList());
        System.out.println(res.toString());
    }

}
