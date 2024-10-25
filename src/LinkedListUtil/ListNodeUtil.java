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

    /**
     * 链表节点数
     * @param head  头节点
     * @return
     */
    public static int sizeOfListNode(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }//end method

    /**
     * 链表对应下标的节点值
     * @param head  头节点
     * @param index 下标
     * @return
     */
    public static int indexOfVal(ListNode head, int index){
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head.val;
    }//end method
}
