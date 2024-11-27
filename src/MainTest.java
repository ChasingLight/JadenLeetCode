import java.util.*;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        /*int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3;
        int candidates = 4;
        System.out.println(totalCost(costs, k, candidates));*/

    }


    public int findKthLargest(int[] nums, int k) {
        // 小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }



    /**
     * 2462 雇佣 K 位工人的总代价
     * 说明：
     * 1 <= costs.length <= 10^5
     * 1 <= costs[i] <= 10^5
     * 1 <= k, candidates <= costs.length
     */
    public static long totalCost(int[] costs, int k, int candidates) {
        // 1个优先级队列 + 每个元素是长度为2的数组（下标0记录值、下标1记录值对应下标）
        // 值不同时，降序排序；如果值相同时，将下标降序排序。
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        // 初始化：是否覆盖全量数据
        int n = costs.length;
        int left = candidates - 1;
        int right = n - candidates;
        if (left + 1 < right) {
            for (int i = 0; i <= left; i++) {
                pq.offer(new int[]{costs[i], i});
            }
            for (int i = right; i < n; i++) {
                pq.offer(new int[]{costs[i], i});
            }
        }else{
            // 覆盖全量数据
            for (int i = 0; i < n; i++) {
                pq.offer(new int[]{costs[i], i});
            }
        }
        // k 轮雇佣
        long res = 0;
        for (int i = 0; i < k; i++) {
            int[] arr = pq.poll();
            int cost = arr[0];
            int index = arr[1];
            res += cost;
            if (left + 1 < right) {
                if (index <= left) {
                    ++left;
                    pq.offer(new int[]{costs[left], left});
                }else if (index >= right) {
                    --right;
                    pq.offer(new int[]{costs[right], right});
                }
            }
        }
        return res;
    }//end method


}
