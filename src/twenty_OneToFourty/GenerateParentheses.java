package twenty_OneToFourty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 22.Generate Parentheses
 * 输出所有可能的n个括号()组合
 */
public class GenerateParentheses {
    //回溯算法
    //相当于一个二叉树，一边是左括号一边是右括号，对其DFS
    //当右括号数>左括号数时，这个节点和他子节点对括号的组合肯定是错误的，直接return
    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n,"");
        return result;
    }

    /**
     * dfs backtrack
     * @param left s中左括号的个数
     * @param right s中右括号的个数
     * @param n 需要的括号对数
     * @param s 现在的字符串
     */
    public void dfs(int left,int right,int n,String s){
        if (left == n && right == n){
            result.add(s);
            return;
        }
        if (left<right) return;
        if (left < n)
            dfs(left+1,right,n,s+"(");
        if (right<n)
            dfs(left,right+1,n,s+")");
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
