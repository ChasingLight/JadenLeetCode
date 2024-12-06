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
        // 构建二叉树
        Integer[] bfsArray = {3,3,null,4,2};
        TreeNode root = TreeBuildUtil.buildByBFS(bfsArray);
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

        System.out.println(goodNodes(root));
    }


    static int count = 0;
    /**
     * 统计二叉树中好节点的数目
     * 说明：二叉树节点数-取值范围 [1,10^5]
     * @param root
     * @return
     */
    public static int goodNodes(TreeNode root) {
        goodNodes(root, Integer.MIN_VALUE);
        return count;
    }

    static void goodNodes(TreeNode root, int max){
        if(root == null) return;
        if (root.val >= max){
            count++;
        }
        max = Math.max(max, root.val);
        goodNodes(root.left, max);
        goodNodes(root.right, max);
    }


}
