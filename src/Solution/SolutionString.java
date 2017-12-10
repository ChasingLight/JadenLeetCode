package Solution;

import TreeUtil.TreeNode;

import java.util.Stack;

//关于String相关的算法解决
public class SolutionString {
	
	/**
	 * 罗马数字转整数
	 * 思路：从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍后然后加上该数
	 * @param s 罗马数字字符串
	 * @return
	 */
	public static int romanToInt(String s){
		char[] word = s.toCharArray();
		//eg:MCMXXC=1000 + 100 + (1000 - 2*100) + 10 + 10 + (100 - 2*10) = 1000 + 900 + 10 + 90 = 2000
		int ret = toNumber(word[0]);  
        for (int i = 1; i < word.length; i++) {  
            if (toNumber(word[i-1]) < toNumber(word[i])) {  
                ret += toNumber(word[i]) - 2 * toNumber(word[i - 1]);  
            } else {  
                ret += toNumber(word[i]);  
            }  
        }  
        return ret;  
	}
	
	/**
	 * 将数字转换为罗马数字
	 * @param num  eg:1964 = "MCMLXIV";
	 * @return
	 */
	public static String intToRoman(int num) {    
	    
	    String[] M = {"","M","MM","MMM"}; //千位
	    String[] C = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//百位
	    String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};//十位
	    String[] I = {"","I","II","III","IV","V","VI","VII","VIII","IX"};//个位
	          
	    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[(num%10)/1];  
	}  
	
	public static int toNumber(char ch) {  
        switch (ch) {  
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
        }  
        return 0;  
    }

	/**
	 * 翻转字符串II: 对于每个2k长度字符串，只翻转前k个字符串即可。
	 *
	 * 额外说明：字符串s和k，范围是[1,10000].
	 * @param s
	 * @param k
	 * @return
	 */
	public static String reverseStrII(String s, int k) {
		char[] word = s.toCharArray();

		for(int i = 0; i < word.length; i+=2*k){
			int a = i;
			int b = (a+k-1) > (word.length-1) ? (word.length-1) : (a+k-1);
			while(a < b){  //翻转字符串
				char temp = word[a];
				word[a] = word[b];
				word[b] = temp;

				a++;
				b--;
			}
		}
		return new String(word);
	}

	/**
	 * 判断机器人是否行驶轨迹是个环，即最终位置和初始位置是同一位置。
	 *
	 * 有效指令：R (Right), L (Left), U (Up), D (down)
	 * @param moves
	 * @return
	 */
	public static boolean judgeCircle(String moves) {
		//特殊情况处理
		if(moves == null || moves.length() == 0)  return true;

		//初始位置坐标(0,0)
		int x = 0;
		int y = 0;
		char[] steps = moves.toCharArray();
		for (int i = 0; i < steps.length; i++) {
			switch (steps[i]){
				case 'U': y++; break;
				case 'D': y--; break;
				case 'L': x--; break;
				case 'R': x++; break;
			}
		}

		return (x==0 && y==0);
	}

	/**
	 * 将二叉树用字符串予以表示
	 *
	 * 缺点：直接使用String，然后使用加号“+”，进行拼接,效率不高。
	 * @param t
	 * @return
	 */
	public static String tree2str(TreeNode t) {
		//递归出口
		if (t == null)
			return "";

		//左右子树，4种情况分别处理
		if (t.left == null && t.right == null)
			return t.val + "";
		if (t.left == null)
			return t.val + "()" + "(" + tree2str(t.right) + ")";
		if (t.right == null)
			return t.val + "(" + tree2str(t.left) + ")";
		return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
	}

	/**
	 * 将二叉树用字符串予以表示  解法2
	 *
	 * 优化使用StringBuffer进行拼接结果。
	 * @param t
	 * @return
	 */
	public static String tree2str2(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		helper(t, sb);
		return sb.toString();
	}

	private static void helper(TreeNode root, StringBuilder sb) {
		//递归出口
		if (root == null)  return;

		//左右子树,分别情况处理
		sb.append(root.val);
		if (root.left != null || root.right != null) {
			sb.append("(");
			helper(root.left, sb);
			sb.append(")");
			if (root.right != null) {
				sb.append("(");
				helper(root.right, sb);
				sb.append(")");
			}
		}

	}



	/**
	 * 学生签到记录 : 如果超过一次A，或者超过连续两次L，将会失去奖学金的资格评比。
	 * 'A' : Absent.
     * 'L' : Late.
     * 'P' : Present.
	 * @param s
	 * @return
	 */
	public static boolean checkRecord(String s) {

		return !((s.indexOf('A') != s.lastIndexOf('A')) || (s.indexOf("LLL") != -1));
        
    }
	
	/**
	 * 校验有效的括号：Valid Parentheses
	 * @param s
	 * @return
	 */
	public static boolean isValid1(String s) {
		//特殊情况处理
		if(s == null)	return false;
		
		//循环处理
		while(s.indexOf("()")!=-1 || s.indexOf("[]")!=-1 || s.indexOf("{}")!=-1){
			s = s.replace("()", "").replace("[]", "").replace("{}", "");
		}
		
		if(s.length() > 0) return false;
		
		return true;
    }
	
	/**
	 * 校验有效的括号：Valid Parentheses
	 * 使用栈---先进后出的数据结构来处理   
	 * @param s
	 * @return
	 * 
	 * ()[]{}
	 * 
	 * {[()]}
	 */
	public static boolean isValid2(String s) {
		//特殊情况处理
		if(s == null)	return false;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : s.toCharArray()){
			if(c == '('){
				stack.push(')');
			}else if(c == '['){
				stack.push(']');
			}else if(c == '{'){
				stack.push('}');
			}else if(stack.isEmpty() || stack.pop()!=c){
				return false;
			}
		}
		
		return stack.isEmpty();
    }
	
	

}
