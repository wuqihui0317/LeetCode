package Sixty_OneToEighty;

import java.util.Stack;

/**
 * @author wub
 * LeetCode
 * 71.Simplify Path
 * 简化路径
 */
public class SimplifyPath {
    //用一个stack存储路径
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int start = -1;
        for (int i = 0; i < path.length(); i++) {
            if (start == -1 && path.charAt(i) != '/'){
                start = i;
            }
            if (start != -1 && (path.charAt(i) == '/' || i == path.length()-1)){
                if (path.charAt(i) != '/')
                    i++;
                //i结尾了
                String str = path.substring(start,i);
                start = -1;
                if (str.equals("..")) {
                    if (!stack.empty())
                        stack.pop();
                }
                else if (!str.equals("."))
                    stack.push(str);
            }
        }
        if (stack.empty())
            return "/";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            result.append('/');
            result.append(stack.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/.././GVzvE/./xBjU///../..///././//////T/../../.././zu/q/e"));
    }
}
