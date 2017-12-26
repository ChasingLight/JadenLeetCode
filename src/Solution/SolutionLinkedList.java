package Solution;


import LinkedListUtil.ListNode;

public class SolutionLinkedList {

	/**
	 * 删除链表中的一个节点(除了尾节点)
	 *
	 * 特殊点：give only access to that node.
	 * @param node
	 */
	public void deleteNode(ListNode node){
		node.val = node.next.val;
		node.next = node.next.next;
	}

	/**
	 * 倒转链表(最简约的方式) 涵盖了空链表和一个节点的情况
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode nxt;
		while(head != null){
			nxt = head.next;
			head.next = pre;
			pre = head;
			head = nxt;
		}
		return pre;
	}

	/**
	 * 倒转链表---递归实现方式
	 * @param head
	 * @return
	 */
	public static ListNode reverseList2(ListNode head) {
		return helper(null, head);
	}

	public static ListNode helper(ListNode pre, ListNode head){
		if (head == null)  return pre;

		ListNode nxt = head.next;
		head.next = pre;
		return helper(head, nxt);

	}
	
	/**
	 * 合并两个有序链表，以l1为主
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(0);  //核心点：以l1为主体，在头部添加一个helper节点，即便第一次l2.val < l1.val,这样插入节点部分代码，通配可用。
        ListNode pre = helper;
        helper.next = l1;
        
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                ListNode nxt = l2.next;
                l2.next = l1;
                pre.next = l2;
                l2 = nxt;
            }else{
                l1 = l1.next;
            }
            
            pre = pre.next;
        }
        
        if(l2 != null){
            pre.next = l2;
        }
        
        return helper.next; 
    }
	
	/**
	 * 合并两个有序链表，从新生成一个链表
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(0);
        ListNode head = helper;
        
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
               helper.next = l2;
               helper = l2;
               l2 = l2.next;
            }else{
            	 helper.next = l1;
                 helper = l1;
                 l1 = l1.next;
            }
        }
        
        if(l1 != null){
        	helper.next = l1;
        }
        
        if(l2 != null){
            helper.next = l2;
        }
        
        return head.next; 
    }

	/**
	 *判断链表是否有环:且涵盖了head为null的处理
	 *
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){  //核心点：循环跳出条件
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)	return true;
		}
		return false;
	}

	/**
	 * 如果链表有循环，返回开始循环的节点；如果链表没有循环，则返回null
	 *
	 * 更考验逻辑：a+b+c+b = 2a+2b => a=c
	 * @param head
	 * @return
	 */
	public static ListNode detectCycle(ListNode head) {  //空链表  链表节点只有一个
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast){//链表有环
				slow = head;
				while(slow != fast){ //核心点
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}

		return null;

	}//end method
	
	/**
	 * 判断一个链表是否为回文链表---第一次书写思路写不出
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		//1.MOVE:利用快慢指针来查找链表中间节点(快步长2,慢步长1)  1->2->3->2->1  
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//2.REVERSE    1->2->3  null<-2<-1
		if(fast != null){ //odd nodes:let the right half smaller
			slow = slow.next;
		}
		slow = reverseList(slow);
		fast = head;
		
		//3.COMPARE
		while(slow != null){
			if(slow.val != fast.val){
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		
		return true;
    }


	 
	 /**
	  * 求两个链表的交点。
	  * 说明：如果没有交点，返回null
	  * @param headA
	  * @param headB
	  * @return
	  */
	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		 
		 if(headA == null || headB == null)  return null;  //移除这行代码仍旧成功。但放这行代码可以加快程序的处理速度
		 
		 //考虑如下情况：Condition1两个链表非空无交点，返回null  Condition2两个链表非空有交点，返回交点处节点 
		 ListNode a = headA;
		 ListNode b = headB;
		 while(a != b){
			 a = (a != null) ? a.next : headB;
			 b = (b != null) ? b.next : headA;
		 }
		 return a;
	 }

	/**
	 * 奇偶链表：将奇数位置的节点放到前面，偶数位置拼接到后面
	 *
	 * @param head 1->2->3->4->5->null
	 * @return
	 */
	public static ListNode oddEvenList(ListNode head) {

		//特殊情况
		if (head == null) return null;

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;  //核心点
		while (even != null && even.next != null) {  //核心点
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;  //核心点

		return head;
	}
	 
	 /**
	  * 移除链表末尾的第n个节点
      *
	  * 说明：不需要前置节点，直接移除欲删除节点，尾节点特殊处理
      * 不涵盖一个节点特殊处理
      *
	  * @param head
	  * @param n
	  * @return
	  */
	 public static ListNode removeNthFromEnd(ListNode head, int n){
		 //特殊情况处理：一个节点
		 if(head.next == null)
			 return null;
		 
		 //查找到欲移除节点
		 ListNode fast = head;
		 ListNode slow = head;
		 ListNode pre = null;
		 for(int i=1; i <= n; i++){
			 fast = fast.next;
		 }
		 while(fast != null){
			 pre = slow;
			 slow = slow.next;
			 fast = fast.next;
		 }
		 
		 //判断删除节点是否为尾节点
		 if(n == 1){
			 pre.next = null;
			 return head;  //核心点
		 }
		 
		 //常规节点移除(非尾节点)
		 slow.val = slow.next.val;
		 slow.next = slow.next.next;
		 return head;
	 }
	 
	 /**
	  * 移除链表末尾的第n个节点
      *
	  * 说明：利用前置节点,来移除欲删除节点，头结点特殊处理
      * 涵盖了一个节点处理情况
	  * @param head
	  * @param n
	  * @return
	  */
	 public static ListNode removeNthFromEnd2(ListNode head, int n){
         ListNode fast = head;
         ListNode slow = head;

         //fast move
         for (int i = 1; i <= n; i++) {
             fast = fast.next;
         }

         //special: remove head
         if(fast == null){
             head = head.next;
             return head;
         }

         //find before node
         while(fast.next != null){
             slow = slow.next;
             fast = fast.next;
         }

         //remove
         slow.next = slow.next.next;
         return head;
	 }

    /**
     * 解法3：为链表头添加一个辅助节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        //add helper node
        ListNode helper = new ListNode(0);
        helper.next = head;

        ListNode fast = helper;
        ListNode slow = helper;

        //move fast
        for (int i = 1; i <= n + 1; i++) {  //核心点：n+1
            fast = fast.next;
        }

        //find before node
        while(fast != null){  //核心点
            slow = slow.next;
            fast = fast.next;
        }

        //remove
        slow.next = slow.next.next;

        return helper.next;

    }


    /**
	  * 链表排序：要求时间复杂度为O(nlogn) 
	  * 此例使用：归并排序
	  * @param head
	  * @return
	  */
	 public static ListNode sortList(ListNode head){
		 return mergeSort(head);
	 }
	 
	 public static ListNode mergeSort(ListNode head){
		 //递归出口
		 if(head == null || head.next == null) return head;
		 
		 //查找链表中点节点
		 ListNode slow = head;
		 ListNode fast = head;
		 while(fast.next != null && fast.next.next != null){
			 slow = slow.next;
			 fast = fast.next.next;
		 }
		 
		 //左右递归
		 ListNode head2 = slow.next;
		 slow.next = null;
		 ListNode head1 = head;
		 
		 head1 = mergeSort(head1);
		 head2 = mergeSort(head2);
		 
		 //合并两个有序链表
		 return mergeTwoLists(head1, head2);
	 }//end method
	 
	 /**
	  * 计算两个链表非负整数的和
	  * @param l1
	  * @param l2
	  * @return
	  */
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		 //特殊情况处理:代码已经可以执行正常
		 
		 int sum = 0;  //数位的和
		 //生成一个新的链表存储结果
		 ListNode helper = new ListNode(-1);
		 ListNode p = helper;
		 while(l1 != null || l2 != null){
			 sum = sum / 10;  //是否进位
			 if (l1 != null) {
				 sum += l1.val;
				 l1 = l1.next;
			 }
			 if(l2 != null){
				 sum += l2.val;
				 l2 = l2.next;
			 }
			 
			 p.next = new ListNode(sum % 10);
			 p = p.next;
		 }
		 
		 if(sum >= 10){
			 p.next = new ListNode(1);
		 }
		 
		 return helper.next;
	 }//end method

}
