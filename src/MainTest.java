import TreeUtil.TreeNode;
import TreeUtil.TreeNodeUtil;

import java.util.Stack;


/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        /*Integer[] preOrder = {3, 9, null, null, 20, 15, null, null, 7, null, null};
        TreeNode root = TreeNodeUtil.buildBinaryTree(preOrder);
        System.out.println(TreeNodeUtil.preorderTraversal(root));
        System.out.println(TreeNodeUtil.inorderTraversal(root));
        System.out.println(TreeNodeUtil.levelOrder(root));*/

        String s = "3[a]2[bc]";  // ab2[cd] => abcdcd
        System.out.println(decodeString(s));
    }


    /**
     * 394 字符串解码
     * 提示： 栈 + 递归
     * 说明：
     *      s.length 取值范围 [1,30]
     *      s 保证是有效输入   【左括号入栈，遇到右括号出栈处理】
     *      s 由 小写字母、数字、中括号 组成。
     */
    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        // 栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 小写字母、数字、左中括号---压栈
            if (s.charAt(i) != ']'){
                stack.push(s.charAt(i));
            }else{
                // 右中括号---出栈
                int k = 0;
                StringBuilder currentSb = new StringBuilder();
                while(stack.peek() != '['){
                    currentSb.append(stack.pop());
                }
                // 弹出-左中括号
                stack.pop();
                currentSb.reverse();
                // 获取 k
                StringBuilder kSb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
                    kSb.append(stack.pop());
                }
                k = Integer.parseInt(kSb.reverse().toString());
                // 解码 k[str]
                StringBuilder decodeCurrentStr = new StringBuilder();
                for (int j = 1; j <= k; j++) {
                    decodeCurrentStr.append(currentSb);
                }
                // 将解码的明文---压栈
                for (int j = 0; j < decodeCurrentStr.length(); j++) {
                    stack.push(decodeCurrentStr.charAt(j));
                }
            }//end else
        }
        // 将栈的内容，反转输出
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }//end method



}
