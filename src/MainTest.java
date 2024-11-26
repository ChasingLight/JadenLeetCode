import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] costs = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;
        System.out.println(totalCost(costs, k, candidates));
    }


    /**
     * 2462 雇佣 K 位工人的总代价
     * 说明：
     * 1 <= costs.length <= 10^5
     * 1 <= costs[i] <= 10^5
     * 1 <= k, candidates <= costs.length
     */
    public static long totalCost(int[] costs, int k, int candidates) {
        // int 数组，转化为 list
        List<Integer> costsList = new ArrayList<>();
        for(int val : costs){
            costsList.add(val);
        }

        long res = 0L;
        // k 轮雇佣
        for (int i = 1; i <= k; i++) {
            int n = costsList.size();
            if (n >= candidates) {
                // 优先队列，实现小根堆 ??? 无法获取元素的对应下标
                // 最前面 candidates 人，对应下标为 [0, candidates-1]
                Integer[] beforeIds = new Integer[candidates];
                for (int j = 0; j < candidates; j++) {
                    beforeIds[j] = j;
                }
                Arrays.sort(beforeIds, Comparator.comparingInt(costsList::get));
                int beforeMinValIndex = beforeIds[0];
                // 最后面 candidates 人，对应下标为 [n-c, n-1]
                Integer[] endIds = new Integer[candidates];
                for (int j = 0; j < candidates; j++) {
                    endIds[j] = n - candidates + j;
                }
                Arrays.sort(endIds, Comparator.comparingInt(costsList::get));
                int endMinValIndex = endIds[0];
                // 判断
                int finalMinValIndex = 0;
                int beforeMinVal = costsList.get(beforeMinValIndex);
                int endMinVal = costsList.get(endMinValIndex);
                if (beforeMinVal > endMinVal) {
                    finalMinValIndex = endMinValIndex;
                }else if(beforeMinVal < endMinVal){
                    finalMinValIndex = beforeMinValIndex;
                }else{
                    finalMinValIndex = Math.min(beforeMinValIndex, endMinValIndex);
                }
                // 累计成本
                res += costsList.get(finalMinValIndex);
                /*System.out.printf("当前是第 %d 轮雇佣\n", i);
                System.out.printf("beforeMinValIndex: %d, endMinValIndex: %d, finalMinValIndex: %d, \n", beforeMinValIndex, endMinValIndex, finalMinValIndex);
                System.out.printf("res = %d\n", res);*/
                costsList.remove(finalMinValIndex);
            }else{
                // 在剩余员工中，选取代价最小
                // 找到 数组中，最小值对应的下标
                Integer[] ids = new Integer[n];
                for (int j = 0; j < n; j++) {
                    ids[j] = j;
                }
                Arrays.sort(ids, Comparator.comparingInt(costsList::get));
                int idMinValIndex = ids[0];
                // 累计成本
                res += costsList.get(idMinValIndex);
                costsList.remove(idMinValIndex);
            }
        }
        return res;
    }//end method


}
