package mainTest;

import LinkedListUtil.ListNode;
import LinkedListUtil.ListNodeUtil;
import Solution.*;
import TreeUtil.TreeNode;
import TreeUtil.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
	
	public static void testAdd(int num){
		System.out.println(num);
	}

	public static void main(String[] args) {
		int[] asceNums = {1, 3, 4, 6, 7, 8, 10, 13, 14};

		TreeNode root = SolutionBinaryTree.sortedArrayToBST(asceNums);

		TreeNodeUtil.levelTraverse(root);
		System.out.println();

		int[] preOrder = {1, 2, 4, 0, 0, 5, 0, 0, 3, 6, 0, 0, 7, 0, 0};  //特例测试：1,2,3,0,0,0,3,2,0,0,0   正常测试：1,2,3,0,0,4,0,0,2,4,0,0,3,0,0

		TreeNode root1 = new TreeNode();
		root1 = TreeNodeUtil.buildBinaryTree(root1, preOrder, 0);

		TreeNodeUtil.levelTraverse(root1);
		System.out.println();

		List<Integer> nums = new ArrayList<>();
		nums = TreeNodeUtil.inTraverse(root1, nums);

		System.out.println(nums);

		System.out.println(SolutionBinaryTree.isSymmetric(root1));

		System.out.println(SolutionBinaryTree.levelOrder(root1));

		int[] preorder = {1, 2, 4, 3, 5};
		int[] inorder = {2, 4, 1, 5, 3};
		int[] postorder = {4, 2, 5, 3, 1};
		TreeNode root444 = TreeNodeUtil.buildTreePreIn2(preorder, inorder);
		System.out.println(SolutionBinaryTree.levelOrder(root444));

		TreeNode root555 = SolutionBinaryTree.buildTreeInPost(inorder, postorder);
		System.out.println(SolutionBinaryTree.levelOrder(root555));

		System.out.println(SolutionBinaryTree.isValidBST(root555));

		System.out.println(SolutionBinaryTree.zigzagLevelOrder2(root555));

		String str = "abcdefg";
		System.out.println(SolutionString.reverseStrII(str, 2));

		System.out.println(SolutionString.tree2str2(root444));

		String valid = "()";
		System.out.println(SolutionString.isValid2(valid));

		String str2 = "A man, a plan, a canal: Panama";
		System.out.println(SolutionString.isPalindrome(str2));

		int[] linked = {1};
		ListNode head = ListNodeUtil.buildListNode(linked);
		head = SolutionLinkedList.removeNthFromEnd2(head, 1);
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

		int[] numss = {1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6};
		System.out.println(SolutionHashTable.singleNumber2(numss));

		int a = 0;
		int b = 9;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + " " + b);

		String s = "loveleetcode";
		System.out.println(SolutionHashTable.firstUniqChar(s));

		String s1 = "rat";
		String t1 = "tar";
		System.out.println(SolutionHashTable.isAnagram2(s1, t1));


		System.out.println(SolutionHashTable.containsDuplicate2(numss));

		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		boolean result = list.contains(3);
		System.out.println(result);

		System.out.println(list);

		int[] test = new int[10];
		System.out.println(test[9]);

		System.out.println(SolutionHashTable.countPrimes2(8));


		int[] nums1 = {1, 1, 1, 2, 2, 3};
		List<Integer> newList = SolutionHashTable.topKFrequent(nums1, 2);
		System.out.println(newList);

		//java中比较类型class是否一致
		String name = "jaden";
		System.out.println(name.getClass().getName());
		System.out.println(String.class.getName());

		System.out.println(String.class.getName().equals(name.getClass().getName()));  //method1:通过名称
		System.out.println(String.class.equals(name.getClass()));  //method2:通过类的类型

		System.out.println(String.class.equals(name.getClass().getName()));  //错误使用

		//java1.8中引入的getClass().getTypeName()方法
		String[][] names = {{"jaden"}, {"bob"}, {"eric"}};
		System.out.println(names.getClass().getTypeName());  //since 1.8
		System.out.println(names.getClass().getName());

		List<Integer> listTest = new ArrayList<>();
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);

		for (Integer temp : listTest) {
			System.out.println(temp);

			if (temp == 1) {
				continue;
			}
		}




	}//end main
	
	


}//end class
