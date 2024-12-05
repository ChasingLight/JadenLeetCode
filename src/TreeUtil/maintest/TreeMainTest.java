package TreeUtil.maintest;

import TreeUtil.TreeAttrUtil;
import TreeUtil.TreeBuildUtil;
import TreeUtil.TreeNode;
import TreeUtil.TreeTraverseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树-相关算法-主测试函数
 * @author jinhaodong
 * @date 2024/11/28 17:32
 */
public class TreeMainTest {

    public static void main(String[] args) {
        // 构建一个二叉树
        Integer[] preOrder = {1,2,null,3,null,null,2,null,3,null,null};
        TreeNode root = TreeBuildUtil.buildByDFS(preOrder);
        // 递归方式遍历：先序、中序、后序
        System.out.println("---递归方式遍历---");
        System.out.println(TreeTraverseUtil.DFS(root));
        System.out.println(TreeTraverseUtil.inorder(root));
        System.out.println(TreeTraverseUtil.postorder(root));
        // 非递归方式遍历：先序、中序、后序
        System.out.println("---非递归方式遍历---");
        System.out.println(TreeTraverseUtil.DFSByStack(root));
        System.out.println(TreeTraverseUtil.inorderRecur(root));
        // 层次遍历
        System.out.println("---层次遍历---");
        System.out.println(TreeTraverseUtil.BFSByQueue(root));
        // 最大深度
        System.out.println("---二叉树的最大深度---");
        System.out.println(TreeAttrUtil.maxDepth(root));
        // 是否对称二叉树（递归）
        System.out.println("---是否对称二叉树（递归）---");
        System.out.println(TreeAttrUtil.isSymmetric(root));
    }


    /**
     * 叶子相似树
     * 说明：两棵树节点数取值范围 [1,200]
     * @param root1
     * @param root2
     * @return
     */
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValueList1 = new ArrayList<>();
        List<Integer> leafValueList2 = new ArrayList<>();
        DFSLeafStack(root1, leafValueList1);
        DFSLeafStack(root2, leafValueList2);
        return leafValueList1.equals(leafValueList2);
    }

    private static void DFSLeaf(TreeNode root, List<Integer> leftValueList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leftValueList.add(root.val);
        }
        DFSLeaf(root.left, leftValueList);
        DFSLeaf(root.right, leftValueList);
    }

    private static void DFSLeafStack(TreeNode root, List<Integer> leftValueList) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                leftValueList.add(node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


}
