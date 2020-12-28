package twenty_OneToFourty;

import java.util.Stack;

/**
 * @author wub
 * LeetCode
 * 32.Longest Valid Parentheses
 * 括号字符串s，返回s最长的括号匹配的长度,字符串中只有小括号()
 */
public class LongestValidParentheses {
    //动态规划
    //用max记录最长匹配长度，dp数组记录当前字符的括号匹配长度
    //遍历s，i为)时，如果i-1是( 则dp[i]=dp[i-2]+2(i-2>=0)
    //               如果i-1是) （有了连续两个)）,如果 i-dp[i-1] - 1>= 0 （保证数组下标不越界）&& i（前面这个下标有可匹配的'(' ）
    //               则dp[i] = 2+ dp[i-1]+dp[i-dp[i-1]-2] (没有越界情况下)
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i-1) == '(')
                    dp[i] = (i>1?dp[i-2]:0)+2;
                else if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(' ){
                    //i-dp[i-1]-2 >=1才有可能他的值大于0（他前面必须要有可配对的(）
                    dp[i] = dp[i-1] + ((i - dp[i - 1]) - 2 >= 1 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                if (dp[i] > max)    max = dp[i];
            }
        }
        return max;
    }
    //栈
    public int fun(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                //空的说明这个右括号无效了
                if (stack.empty()){
                    stack.push(i);
                }else{
                    if(max < i-stack.peek())    max = i-stack.peek();
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")(((((()())()()))()(()))("));
    }
}
