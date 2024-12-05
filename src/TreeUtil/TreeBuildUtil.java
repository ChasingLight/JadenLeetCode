package TreeUtil;

import java.util.*;


/**
 * 二叉树-构建-工具类
 */
public class TreeBuildUtil {
	
	public static int index = 0;
	/**
	 * 先序构造二叉树:递归实现
	 * 缺点：使用了一个静态变量 index 进行构建
	 * @param a		二叉树先序遍历数组
	 * @return
	 */
	public static TreeNode buildByDFS(Integer[] a){
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
		root.left = buildByDFS(a);
		root.right = buildByDFS(a);
		return root;
	}//end method


	/**
	 * 层次遍历结果，构建二叉树
	 * @param array		二叉树层次遍历数组
	 * @return
	 */
	public static TreeNode buildByBFS(Integer[] array){
		if (array == null || array.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(array[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int i = 1;
		while (!queue.isEmpty() && i < array.length) {
			int levelSize = queue.size();
			for (int j = 0; j < levelSize; j++) {
				TreeNode node = queue.poll();
				if (i < array.length && array[i] != null) {
					node.left = new TreeNode(array[i]);
					queue.offer(node.left);
				}
				i++;
				if (i < array.length && array[i] != null) {
					node.right = new TreeNode(array[i]);
					queue.offer(node.right);
				}
				i++;
			}
		}
		return root;
	}
	
	
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

}

