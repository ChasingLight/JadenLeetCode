package LinkedListUtil;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtil {

    /**
     * 构建链表
     * @param input 整数数组
     * @return
     */
    public static ListNode buildListNode(int[] input) {
        ListNode head = null, last = null, newNode;
        for (int val : input) {
            newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
        }
        return head;
    }//end method

    /**
     * 展示链表信息
     * @param head  头节点
     * @return
     */
    public static List<Integer> showListNode(ListNode head) {
        List<Integer> output = new ArrayList<>();
        if (head == null) {
            return null;
        }
        while (head != null) {
            output.add(head.val);
            head = head.next;
        }
        return output;
    }//end method
}
