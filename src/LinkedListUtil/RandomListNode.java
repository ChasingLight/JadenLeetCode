package LinkedListUtil;

public class RandomListNode {
	public int label;  
    public RandomListNode next,random;  //相比常规链表节点，多了一个random指针，它可以指向这个链表中的任何节点，或者指向null
	public RandomListNode(int x) { 
		this.label = x; 
	}

}
