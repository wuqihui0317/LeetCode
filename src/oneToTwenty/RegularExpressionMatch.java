package oneToTwenty;
/**
 * @author w``ub
 * LeetCode
 * 10.Regular Expression Match
 */
public class RegularExpressionMatch {
    //*的作用：1. .* 什么都能匹配；2. a* 0~n个a    即无限重复前一个字符
    //思路：递归.当p1== * 时，要一个一个地匹配s0~len-1。如果*后面有字符，
    //      需要在每次匹配s0~len-1与p0时，进行匹配当前匹配的s后一个字符与p2匹配的情况
    public boolean isMatch(String s, String p) {
        //p.len == 0
        if (p.isEmpty()) return s.isEmpty();
        //判断第一个字符是否匹配.没有匹配时，在第二个字符为*的情况下还可以匹配
        boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //p.len > 1
        if (p.length() > 1 && p.charAt(1) == '*') {
            //*用作0 || 1+
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        }
        //p.len == 1 时
        else return first_match && isMatch(s.substring(1), p.substring(1));
    }

    //动态规划
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatch().isMatch("aaa", "a*a"));
    }
}
