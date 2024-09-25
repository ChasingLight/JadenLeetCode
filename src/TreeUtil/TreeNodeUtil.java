package TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNodeUtil {
	
	public static int index = 0;
	/**
	 * 先序构造二叉树:递归实现
	 * 缺点：使用了一个静态变量 index 进行构建
	 * @param a		二叉树先序遍历数组
	 * @return
	 */
	public static TreeNode buildBinaryTree(Integer[] a){
		if (index >= a.length) {
			return null;
		}
		// 空节点
		if (a[index] == null) {
			index++;
			return null;
		}
		// 创建当前节点
		TreeNode root = new TreeNode(a[index]);
		// 移动到下一个元素
		index++;
		// 构建左子树和右子树
		root.left = buildBinaryTree(a);
		root.right = buildBinaryTree(a);
		return root;
	}//end method
	
	
	/**
	 * 广度优先遍历构建二叉树：递归实现
	 * 利用归路：index根，左孩子为index*2，右孩子为index*2+1
	 * @param a
	 * @param index
	 * @return
	 */
	public static TreeNode makeBinaryTreeByArray(int[] a, int index){
		if(index < a.length){
			int value = a[index];
			if(value != 0){
				TreeNode node = new TreeNode(value);
				//a[index]=0;
				node.left = makeBinaryTreeByArray(a, index*2);
				node.right = makeBinaryTreeByArray(a, index*2+1);   //{0,1,2,3,4,5,6,7,0,0,0,0,0,0,0,0}
				return node;
			}
		}
		return null;
	}
	
	/**
	 * jaden 先序、中序生成树  
	 * 
	 * 先序遍历用于找树的根，中序遍历用于切分左右子树
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTreePreIn2(int[] preorder,int[] inorder){
		return helper2(0, 0, inorder.length - 1, preorder, inorder);
	}
	
	public static TreeNode helper2(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {  
	    //递归出口
		if(inStart > inEnd){
			return null;
		}
		
		int rootVal = preorder[preIndex];
		
	    TreeNode root = new TreeNode(rootVal);
	    int inIndex = 0;  //Index of current root in inorder array
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == rootVal) inIndex = i;
	    }
	    
	    //左子树根节点，在先序数组中的下标 = preIndex + 1
	    root.left = helper2(preIndex + 1, inStart, inIndex - 1, preorder, inorder);
	    
	    //核心点：右子树根节点，在先序数组中的下标 = preIndex + 左子树节点个数  + 1
	    root.right = helper2(preIndex + inIndex-1 - inStart + 1 + 1, inIndex + 1, inEnd, preorder, inorder);
	    
	    return root;
	}
	
	
	/**
	 * 广度优先遍历BFS：非递归实现
	 * @param root
	 * 
	 * 说明：队列是先入先出的数据结构(FIFO)  very nice!
	 */
	public static void levelTraverse(TreeNode root) {
		
		//特殊情况处理：空树
		if (root == null) {
			System.out.println("这是一个空树直接返回");
			return;
		}
		
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);// 从根节点入队列
        while (!queue.isEmpty()) {// 在队列为空前反复迭代
            TreeNode TreeNode = queue.poll();// 取出队列首节点
            System.out.print(TreeNode.val + " ");
            if (TreeNode.left != null)
                queue.offer(TreeNode.left);// 左孩子入列
            if (TreeNode.right != null)
                queue.offer(TreeNode.right);// 右孩子入列
        }
    }
	
	/**
	 * 先序遍历二叉树：递归实现
	 * @param root
	 */
	public static List<Integer> preorderTraversal(TreeNode root){
		List<Integer> ret = new ArrayList<>();
		if (root == null){
			return ret;
		}
		ret.add(root.val);
		List<Integer> leftTree = preorderTraversal(root.left);
		ret.addAll(leftTree);
		List<Integer> rightTree = preorderTraversal(root.right);
		ret.addAll(rightTree);
		return ret;
	}
	
	/**
	 * 先序遍历：非递归实现(DFS深度优先遍历)
	 * 
	 * @param root
	 */
	public static void perTraverseNoRecursion(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) {//先右后左，右节点先入栈
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}//end while
		
	}//end method
	
	/**
	 * 中序遍历二叉树：递归实现
	 * @param root
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null){
			return ret;
		}
		// 左子树
		List<Integer> leftTree = inorderTraversal(root.left);
		ret.addAll(leftTree);
		// 根
		ret.add(root.val);
		// 右子树
		List<Integer> rightTree = inorderTraversal(root.right);
		ret.addAll(rightTree);
		return ret;
	}
	
	/**
	 * 中序遍历二叉树：非递归实现   --- 中序遍历的非递归实现方式考察，好好看看
	 * @param root
	 */
	public static List<Integer> inTraverseNoRecursion(TreeNode root){
		
		List<Integer> list = new ArrayList<>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			while(stack.peek() != null) //向左走到尽头
				stack.push(stack.peek().left);
			
			stack.pop();  //空指针出栈
			
			if (!stack.isEmpty()) {  //访问节点，向右一步
				TreeNode node = stack.pop();
				list.add(node.val);
				stack.push(node.right);
			}
		}
		
		return list;
	}
	
	/**
	 * 后序遍历二叉树：递归实现
	 * @param root
	 */
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null){
			return ret;
		}
		// 左子树
		List<Integer> leftTree = postorderTraversal(root.left);
		ret.addAll(leftTree);
		// 右子树
		List<Integer> rightTree = postorderTraversal(root.right);
		ret.addAll(rightTree);
		// 根
		ret.add(root.val);
		return ret;
	}

	
	/**
	 * 中序遍历:递归实现，同时返回一个列表
	 * 
	 * @param root
	 * @param nums
	 * @return
	 */
	public static List<Integer> inTraverse(TreeNode root, List<Integer> nums){
		if(root == null){
			return null;
		}
		
		inTraverse(root.left, nums);
		nums.add(root.val);
		inTraverse(root.right, nums);
		
		return nums;
	}
	
}

