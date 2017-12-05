package Solution;

import TreeUtil.TreeNode;

import java.util.*;

public class SolutionBinaryTree {
	
	/**
	 * 求二叉树的深度
	 * @param root
	 * @return
	 */
    public static int maxDepth(TreeNode root) {
    	if(root == null) return 0;
    	
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }//end method
    
    /**
     * 求二叉树的深度 : 非递归实现，BFS广度优先遍历
     * @param root
     * @return
     */
    public static int maxDepthBFS(TreeNode root) {//一层一层循环完毕，走完一层，深度加1
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size(); //*****容易出错*****
            while(size-- > 0) {  //先做比较 再减1
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }//end method
    
    /**
     * 求二叉树的深度 : 非递归实现，DFS深度优先遍历
     * @param root
     * @return
     */
    public static int maxDepthDFS(TreeNode root) {  //所有结点中最大的层次数，就是树的深度
    	if(root == null) return 0;
    	
    	Stack<TreeNode> nodes = new Stack<>();
    	Stack<Integer> level = new Stack<>();
    	
    	//初始条件
    	nodes.push(root);
    	level.push(1);
    	int maxLevel = 0;  //最大层次数
    	
    	while(!nodes.isEmpty()){
    		TreeNode currNode = nodes.pop();
    		int currLevel = level.pop();
    		maxLevel = Math.max(currLevel, maxLevel);  //局部最优解
    		
    		if (currNode.left != null) {
				nodes.push(currNode.left);
				level.push(currLevel+1);
			}
    		if (currNode.right != null) {
				nodes.push(currNode.right);
				level.push(currLevel+1);
			}
    	}
    	
		return maxLevel;
		
    }//end method
    
    /**
     * 通过一个升序数组，构建二叉搜索树(Binary Search Tree)
     * 
     * 同时要求是一个平衡二叉搜索树
     * @param num
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
       
        return helper(num, 0, num.length - 1);
    }

    public static TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done 递归出口
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);  //左半部分递归
        node.right = helper(num, mid + 1, high); //右半部分递归
        return node;
    }
   
    
    /**
     * 二叉搜索树(Binary Search Tree)：插入元素
     * @param root
     * @param element
     * @return
     */
    public static boolean insertBST(TreeNode root, int element){
    	if(root == null){  //空树情况
    		root = new TreeNode();
    		root.val = element;
    		root.left = root.right = null;
    	}else if(element == root.val){
    		return false;
    	}else if(element < root.val){
    		insertBST(root.left, element);
    	}else{
    		insertBST(root.right, element);
    	}
    	
    	return true;
    	
    }//end method
    
    
    /**
     * 判断一个树，是否为对称树
     * 
     * 使用BFS遍历,一层一层进行判断
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
    	if (root == null) return true;
		
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);  
    	int levelSize = 0;  //每层节点的个数
    	List<Integer> levelNodeValue = new ArrayList<>();  //每层节点值列表
    	
    	while(!queue.isEmpty()){
    		levelSize = queue.size();
    		levelNodeValue.clear();
    		
    		while(levelSize-- > 0){   //层次遍历完毕
    			TreeNode node = queue.poll();
    			levelNodeValue.add(node.val);
    			
    			if (node.left != null) queue.offer(node.left);
				
    			if (node.right != null) queue.offer(node.right);
				
    		}
    		
    		if (!isSymmetricList(levelNodeValue)) {
				return false;
			}
    	}
    	
    	return true;
    }
    
    /**
     * 判断一个数组，是否为对称的
     * 
     * @param nums
     * @return
     */
    public static boolean isSymmetricList(List<Integer> nums) {
    	int i = 0;
    	int j = nums.size() - 1;
    	while(i < j){
    		if(nums.get(i) != nums.get(j)){
    			return false;
    		}
    		i++;
    		j--;
    	}
    	
    	return true;
    }
    
    /**
     * 判断一个树，是否为对称树
     * 
     * 使用递归处理
     * @param root
     * @return
     */
    public static boolean isSymmetricRecusive(TreeNode root) {
       if(root == null) return true;  //空树是对称树
       return isMirror(root.left, root.right);
    }
    public static boolean isMirror(TreeNode p, TreeNode q) {  
        if(p == null && q == null) return true;  //递归出口
        if(p == null || q == null) return false;  //递归出口
        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);  //通用规律
    }
    
    /**
     * 判断一个树，是否为对称树
     * 
     * 使用非递归处理
     * @param root
     * @return
     */
    public static boolean isSymmetricNoRecusive(TreeNode root) {
    	//特殊情况处理
    	if(root == null) return true;
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root.left);
    	queue.offer(root.right);
    	while(!queue.isEmpty()){
    		TreeNode leftTree = queue.poll();
    		TreeNode rightTree = queue.poll();
    		
    		if(leftTree == null && rightTree == null) continue;
    		if(leftTree == null || rightTree == null) return false;
    		if (leftTree.val != rightTree.val) return false;
			queue.offer(leftTree.left);
			queue.offer(rightTree.right);
			queue.offer(leftTree.right);
			queue.offer(rightTree.left);
    	}
    	
    	return true;
    }
    
    /**
     * 二叉树层次遍历---使用队列(FIFO)
     * 
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	
    	if (root == null) {  //空树
			return result;
		}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	int levelSize = 0;
    	while(!queue.isEmpty()){
    		levelSize = queue.size();
    		List<Integer> levelValue = new ArrayList<>();
    		while(levelSize-- > 0){  //一层遍历完毕
    			TreeNode node = queue.poll();
    			levelValue.add(node.val);

    			if(node.left != null) queue.offer(node.left);
    			if(node.right != null) queue.offer(node.right);
    		}
    		
    		result.add(levelValue);
    	}
    	return result;
    }//end method
    
    
    /**
     * 获取二叉搜索树BST中，第K个最小元素---非递归实现
     * 
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
    	int result = 0;
    	int count = 0;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			while(stack.peek() != null) //向左走到尽头
				stack.push(stack.peek().left);
			
			stack.pop();  //空指针出栈
			
			if (!stack.isEmpty()) {  //访问节点，向右一步
				TreeNode node = stack.pop();
				count++;
				if (count == k) {
					result = node.val;
				}
				stack.push(node.right);
			}
		}
		
		return result;
    }
    
    /**
     * jaden 使用中序遍历和后续遍历构建树
     * 
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTreeInPost(int[] inorder, int[] postorder) {
    	
        return helper(postorder.length-1, 0, inorder.length-1, postorder, inorder);
    }
    
    public static TreeNode helper(int postIndex, int inStart, int inEnd, int[] postorder, int[] inorder){
    	if(inStart > inEnd){
    		return null;
    	}
    	
    	int rootValue = postorder[postIndex];
    	
    	TreeNode node = new TreeNode(rootValue);
    	int inIndex = 0;  //当前根节点值在中序数组中下标
    	for(int i = inStart; i <= inEnd; i++){
    		if(inorder[i] == rootValue) {
    			inIndex = i;
    			break;
    		}
    	}

    	int leftRootIndex = postIndex - (inEnd - (inIndex+1) + 1) - 1;

		//右子树根节点，在后序数组中的下标 = preIndex-1
    	node.right = helper(postIndex - 1, inIndex+1, inEnd, postorder, inorder);

		//左子树根节点，在后序数组中的下标 = preIndex-右子树节点个数-1
		node.left = helper(leftRootIndex, inStart, inIndex-1, postorder, inorder);
    
    	return node;
    }


	/**
	 * 校验树是否为 二叉搜索树
	 *
	 *
	 * @param root
	 * @return
	 */
	public static boolean isValidBST(TreeNode root){
		//特殊情况处理:空树是BST
		if(root == null) return true;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		TreeNode preNode = null;
		
		while(!stack.isEmpty()){
			while(stack.peek() != null) //向左走到尽头
				stack.push(stack.peek().left);
			
			stack.pop();  //空指针出栈
			
			if (!stack.isEmpty()) {  //访问节点，向右一步
				TreeNode node = stack.pop();
				
				if(preNode != null && node.val <= preNode.val) return false;   //核心点:遍历第一个节点值，不进行比较
				preNode = node;
				
				stack.push(node.right);
			}
		}
		
		return true;
	}
    
  
}
