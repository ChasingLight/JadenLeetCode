import TreeUtil.TreeNode;
import TreeUtil.TreeNodeUtil;


/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        Integer[] preOrder = {1,2,4,5,6,7,3,null,8,9};
        TreeNode root = TreeNodeUtil.buildBinaryTree(preOrder);
        System.out.println(TreeNodeUtil.preorderTraversal(root));
        System.out.println(TreeNodeUtil.inorderTraversal(root));
    }

}
