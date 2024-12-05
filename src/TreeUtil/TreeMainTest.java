package TreeUtil;

/**
 * 树-相关算法-主测试函数
 * @author jinhaodong
 * @date 2024/11/28 17:32
 */
public class TreeMainTest {

    public static void main(String[] args) {
        // 构建一个二叉树
        Integer[] preOrder = {1,2,null,3,null,null,2,null,3,null,null};
        TreeNode root = TreeNodeUtil.buildBinaryTree(preOrder);
        // 递归方式遍历：先序、中序、后序
        System.out.println("---递归方式遍历---");
        System.out.println(TreeNodeUtil.preorderTraversal(root));
        System.out.println(TreeNodeUtil.inorderTraversal(root));
        System.out.println(TreeNodeUtil.postorderTraversal(root));
        // 非递归方式遍历：先序、中序、后序
        System.out.println("---非递归方式遍历---");
        System.out.println(TreeNodeUtil.perTraverseNoRecursion(root));
        System.out.println(TreeNodeUtil.inTraverseNoRecursion(root));
        // 层次遍历
        System.out.println("---层次遍历---");
        System.out.println(TreeNodeUtil.levelOrder(root));
        // 层次遍历（包含null）
        System.out.println("---层次遍历（包含null）---");
        System.out.println(TreeNodeUtil.levelOrderWithNil(root));
        // 最大深度
        System.out.println("---二叉树的最大深度---");
        System.out.println(TreeNodeUtil.maxDepth(root));
        // 是否对称二叉树（非递归-层次遍历）
        System.out.println("---是否对称二叉树（非递归-层次遍历）---");
        System.out.println(TreeNodeUtil.isSymmetric(root));
        // 是否对称二叉树（递归）
        System.out.println("---是否对称二叉树（递归）---");
        System.out.println(TreeNodeUtil.isSymmetricRecursion(root));

    }

    /**
     * 路径总和
     * 说明：树中节点的数目在范围 [0, 5000]
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }//end method
}
