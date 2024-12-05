package TreeUtil;

/**
 * 二叉树-属性-工具类
 */
public class TreeAttrUtil {

    /**
     * 最大深度
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }//end method

    /**
     * 对称二叉树
     */
    public static boolean isSymmetric(TreeNode root){
        return null == root || isSymmetric(root.left, root.right);
    }

    /**
     * 私有方法：是否对称二叉树，递归实现
     */
    private static boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        }
        // 只有一个越过叶子节点 或 节点值不同，树不对称
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
