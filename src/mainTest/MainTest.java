package mainTest;

import java.util.ArrayList;
import java.util.List;

import Solution.SolutionBinaryTree;
import TreeUtil.TreeNode;
import TreeUtil.TreeNodeUtil;

public class MainTest {
	
	public static void testAdd(int num){
		System.out.println(num);
	}

	public static void main(String[] args) {
		int[] asceNums = {1,3,4,6,7,8,10,13,14};  
		
		TreeNode root = SolutionBinaryTree.sortedArrayToBST(asceNums);
		
		TreeNodeUtil.levelTraverse(root);
		System.out.println();
		
		int[] preOrder = {1,2,3,0,0,4,0,0,2,4,0,0,3,0,0};  //特例测试：1,2,3,0,0,0,3,2,0,0,0   正常测试：1,2,3,0,0,4,0,0,2,4,0,0,3,0,0
		
		TreeNode root1 = new TreeNode(); 
		root1 = TreeNodeUtil.buildBinaryTree(root1, preOrder, 0);
		
		TreeNodeUtil.levelTraverse(root1);
		System.out.println();
		
		List<Integer> nums = new ArrayList<>();
		nums = TreeNodeUtil.inTraverse(root1, nums);
		
		System.out.println(nums);
		
		System.out.println(SolutionBinaryTree.isSymmetric(root1));
		
		root1 = null;
		System.out.println(SolutionBinaryTree.levelOrder(root1));
		
		int[] preorder = {1,2,4,5,3,6,7};
		int[] inorder = {4,2,5,1,6,3,7};
		int[] postorder = {4,5,2,6,7,3,1};
		TreeNode root444 = TreeNodeUtil.buildTreePreIn2(preorder, inorder);
		System.out.println(SolutionBinaryTree.levelOrder(root444));
		
		TreeNode root555 = SolutionBinaryTree.buildTreeInPost(inorder, postorder);
		System.out.println(SolutionBinaryTree.levelOrder(root555));

	}
	
	


}
