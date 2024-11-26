import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums1 = {4,2,3,1,1};
        int[] nums2 = {7,5,10,9,6};
        int k = 1;
        System.out.println(maxScore(nums1, nums2, k));
    }


    /**
     * 2542 最大子序列分数
     * 一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。
     * 说明：
     *  n == nums1.length == nums2.length
     *  1 <= n <= 105
     *  1 <= k <= n
     *  0 <= nums1[i], nums2[j] <= 105
     *
     */
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        // 对下标进行排序，不影响原数组的顺序
        Arrays.sort(ids, (i, j)->nums2[j]-nums2[i]);

        // 贪心
        long res;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            sum += nums1[ids[i]];
            pq.offer(nums1[ids[i]]);
        }
        res = sum * nums2[ids[k-1]];

        // 减小 min(nums2)
        for (int i = k; i < n; i++) {
            // 当前 nums2 最小值为 nums2[ids[i]]
            int x = nums1[ids[i]];
            if (x > pq.peek()) {
                sum = sum - pq.poll() + x;
                pq.offer(x);
                res = Math.max(res, sum * nums2[ids[i]]);
            }
        }
        return res;
    }//end method


}
