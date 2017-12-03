package Solution;

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
		char[] word = s.toCharArray();  //eg:MCMXXC=1000 + 100 + (1000 - 2*100) + 10 + 10 + (100 - 2*10) = 1000 + 900 + 10 + 90 = 2000
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
