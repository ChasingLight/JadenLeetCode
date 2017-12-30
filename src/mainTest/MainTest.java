package mainTest;

import LinkedListUtil.ListNode;
import LinkedListUtil.ListNodeUtil;
import Solution.SolutionBinaryTree;
import Solution.SolutionLinkedList;
import Solution.SolutionMath;
import Solution.SolutionString;
import TreeUtil.TreeNode;
import TreeUtil.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
	
	public static void testAdd(int num){
		System.out.println(num);
	}

	public static void main(String[] args) {
		int[] asceNums = {1,3,4,6,7,8,10,13,14};  
		
		TreeNode root = SolutionBinaryTree.sortedArrayToBST(asceNums);
		
		TreeNodeUtil.levelTraverse(root);
		System.out.println();
		
		int[] preOrder = {1,2,4,0,0,5,0,0,3,6,0,0,7,0,0};  //特例测试：1,2,3,0,0,0,3,2,0,0,0   正常测试：1,2,3,0,0,4,0,0,2,4,0,0,3,0,0
		
		TreeNode root1 = new TreeNode(); 
		root1 = TreeNodeUtil.buildBinaryTree(root1, preOrder, 0);
		
		TreeNodeUtil.levelTraverse(root1);
		System.out.println();
		
		List<Integer> nums = new ArrayList<>();
		nums = TreeNodeUtil.inTraverse(root1, nums);
		
		System.out.println(nums);
		
		System.out.println(SolutionBinaryTree.isSymmetric(root1));
		
		System.out.println(SolutionBinaryTree.levelOrder(root1));
		
		int[] preorder = {1,2,4,3,5};
		int[] inorder = {2,4,1,5,3};
		int[] postorder = {4,2,5,3,1};
		TreeNode root444 = TreeNodeUtil.buildTreePreIn2(preorder, inorder);
		System.out.println(SolutionBinaryTree.levelOrder(root444));
		
		TreeNode root555 = SolutionBinaryTree.buildTreeInPost(inorder, postorder);
		System.out.println(SolutionBinaryTree.levelOrder(root555));
		
		System.out.println(SolutionBinaryTree.isValidBST(root555));

		System.out.println(SolutionBinaryTree.zigzagLevelOrder2(root555));

		String str = "abcdefg";
		System.out.println(SolutionString.reverseStrII(str,2));

		System.out.println(SolutionString.tree2str2(root444));

		String valid = "()";
		System.out.println(SolutionString.isValid2(valid));

		String str2 = "A man, a plan, a canal: Panama";
		System.out.println(SolutionString.isPalindrome(str2));

		int[] linked = {1};
		ListNode head = ListNodeUtil.buildListNode(linked);
		head = SolutionLinkedList.removeNthFromEnd2(head,1);
		System.out.println(ListNodeUtil.showListNode(head));

		String treeStr = SolutionBinaryTree.serialize(root1);
		System.out.println(treeStr);

		TreeNode treeTest = SolutionBinaryTree.deserialize(treeStr);
		TreeNodeUtil.levelTraverse(treeTest);
		System.out.println();

		int n = 23;
		System.out.println(SolutionMath.isHappy(n));
		System.out.println(SolutionMath.calculateNewN(n));

		System.out.println(SolutionBinaryTree.maxPathSum(root1));


	}
	
	


}
