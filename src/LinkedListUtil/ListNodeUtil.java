package LinkedListUtil;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtil {
	
	/**
	 * 根据leetcode的ListNode定义，构建链表
	 * @param input
	 * @return
	 */
	public static ListNode buildListNode(int[] input){
        ListNode first = null,last = null,newNode;
        if(input.length > 0){
            for(int i=0;i<input.length;i++){
                newNode=new ListNode(input[i]);
                newNode.next = null;
                if(first==null){
                    first=newNode;
                    last=newNode;
                }
                else{
                    last.next=newNode;
                    last=newNode;
                }

            }
        }
        return first;
    }
	
	
	public static List<Integer> showListNode(ListNode head){
		List<Integer> output = new ArrayList<>();
		
		if(head == null){
			return null;
		}
		
		while(head != null){
			output.add(head.val);
			head = head.next;
		}
		
		return output;
	}
}
