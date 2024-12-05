package TreeUtil.maintest;

import TreeUtil.TreeAttrUtil;
import TreeUtil.TreeBuildUtil;
import TreeUtil.TreeNode;
import TreeUtil.TreeTraverseUtil;

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
}
