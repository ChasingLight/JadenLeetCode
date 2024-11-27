import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] costs = {2,1,2};
        int k = 1;
        int candidates = 1;
        System.out.println(totalCost(costs, k, candidates));

    }


    /**
     * 2462 雇佣 K 位工人的总代价
     * 说明：
     * 1 <= costs.length <= 10^5
     * 1 <= costs[i] <= 10^5
     * 1 <= k, candidates <= costs.length
     */
    public static long totalCost(int[] costs, int k, int candidates){
        // 解法2：剪枝、2个小顶堆、2个队头比较
        long res = 0L;
        int n = costs.length;
        // 可全量覆盖 costs 所有元素
        if (k >= 1 + n - 2*candidates) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }
        // 未全量覆盖，初始化
        PriorityQueue<Integer> leftPq = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            leftPq.offer(costs[i]);
        }
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();
        for (int i = n-candidates; i < n; i++) {
            rightPq.offer(costs[i]);
        }
        // k 轮雇佣
        int left = candidates - 1;
        int right = n - candidates;
        for (int i = 0; i < k; i++) {
            // 代价相同，选左侧下标更小
            int cost;
            if (leftPq.peek() <= rightPq.peek()){
                cost = leftPq.poll();
                leftPq.offer(costs[++left]);
            }else{
                cost = rightPq.poll();
                rightPq.offer(costs[--right]);
            }
            res += cost;
        }
        return res;
    }//end method


}
