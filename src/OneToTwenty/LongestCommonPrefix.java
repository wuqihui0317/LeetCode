package OneToTwenty;
/**
 * @author wub
 * LeetCode
 * 14.Longest Common Prefix
 * 找出一个字符串数组中最长的相同前缀
 */
public class LongestCommonPrefix {
    //思路：先找到strs中最短的字符串，根据这个字符串进行匹配
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        else if (strs.length == 1)
            return strs[0];
        else {
            StringBuilder sb = new StringBuilder();
            int min = 0;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < strs[min].length())
                    min = i;
            }
            for (int i = 0; i < strs[min].length(); i++) {
                for (int j = 0; j < strs.length; j++) {
                    if (j == min) continue;
                    else if (strs[j].charAt(i) != strs[min].charAt(i))
                        return sb.toString();
                }
                sb.append(strs[min].charAt(i));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"", "b"}));
    }
}
