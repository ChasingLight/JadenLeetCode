package TreeUtil;

import java.util.*;

/**
 * 二叉树-遍历-工具类
 */
public class TreeTraverseUtil {

	/**
	 * BFS遍历（队列）
	 * 说明：BFS遍历 <=> 层次遍历，是同一个东西。
	 */
	public static List<List<Integer>> BFSByQueue(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		// 空树
		if (root == null) {
			return result;
		}
		// 根节点入队列
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int levelSize;
		// 逐层遍历
		while (!queue.isEmpty()) {
			levelSize = queue.size();
			List<Integer> levelValueList = new ArrayList<>(levelSize);
			// 记录当前层-节点值，同时将下一层节点入队列
			while(levelSize-- > 0){
				TreeNode node = queue.poll();
				levelValueList.add(node.val);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			result.add(levelValueList);
		}
		return result;
	}//end method

	/**
	 * DFS遍历
	 * 说明：DFS遍历 <=> 先序遍历，是同一个东西。
	 */
	public static List<Integer> DFS(TreeNode root){
		List<Integer> ret = new ArrayList<>();
		// 空树
		if (root == null){
			return ret;
		}
		// 根
		ret.add(root.val);
		// 左子树
		List<Integer> leftTree = DFS(root.left);
		ret.addAll(leftTree);
		// 右子树
		List<Integer> rightTree = DFS(root.right);
		ret.addAll(rightTree);
		return ret;
	}

	/**
	 * DFS遍历（栈）
	 */
	public static List<Integer> DFSByStack(TreeNode root){
		List<Integer> res = new ArrayList<>();
		// 空树
		if (root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			res.add(node.val);
			// 先右后左，右节点先入栈
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}//end while
		return res;
	}//end method

	/**
	 * 中序遍历
	 */
	public static List<Integer> inorder(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null){
			return ret;
		}
		// 左子树
		List<Integer> leftTree = inorder(root.left);
		ret.addAll(leftTree);
		// 根
		ret.add(root.val);
		// 右子树
		List<Integer> rightTree = inorder(root.right);
		ret.addAll(rightTree);
		return ret;
	}

	/**
	 * 中序遍历（栈）
	 */
	public static List<Integer> inorderRecur(TreeNode root){
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
	 * 后序遍历
	 */
	public static List<Integer> postorder(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null){
			return ret;
		}
		// 左子树
		List<Integer> leftTree = postorder(root.left);
		ret.addAll(leftTree);
		// 右子树
		List<Integer> rightTree = postorder(root.right);
		ret.addAll(rightTree);
		// 根
		ret.add(root.val);
		return ret;
	}


}

