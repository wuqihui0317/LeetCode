package OneToTwenty;
import java.util.*;

/**
 * @author wub
 * LeetCode
 * 20.Valid Parentheses（括号，插入语）
 * 判断所给字符串是不是有效的括号
 */
public class ValidParentheses {
    //思路：分别用left、right记录所有的左括号和右括号
    //如果遇到左括号，入栈他的右括号，如果栈空且遇到右括号，返回false
    //如果栈非空且遇到右括号，如果当前栈顶是这个括号，出栈
    //遍历完s如果栈非空，返回false 否则返回true
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('[', ']');
        parentheses.put('{', '}');
        Set left = parentheses.keySet();
        Set<Character> right = new HashSet<>(parentheses.values());
        Deque<Character> stack = new ArrayDeque();
        for (char ch : str) {
            if (left.contains(ch))
                stack.addLast(parentheses.get(ch));
            else {
                if (stack.isEmpty())
                    return false;
                else if (ch == stack.pollLast()) ;
                else return false;
            }
        }
        if (stack.isEmpty())
            return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }
}
