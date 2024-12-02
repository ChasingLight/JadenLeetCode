package TreeUtil;

/**
 * 树-相关算法-主测试函数
 * @author jinhaodong
 * @date 2024/11/28 17:32
 */
public class TreeMainTest {

    public static void main(String[] args) {
        // 构建一个二叉树
        Integer[] preOrder = {1,2,null,null,3,null,null};
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
    }
}
