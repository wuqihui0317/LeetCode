package Forty_OneToSixty;
/**
 * @author wub
 * LeetCode
 * 44.Wildcard Matching
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * 字符串匹配：*代表一个字符串（可控），？代表一个字符
 */
public class WildcardMatching {
    //递归
    //会超时！！！
    public boolean isMatch(String s, String p) {
        if (p.equals("*"))  return true;
        int index_s,index_p;
        for (index_p = 0,index_s = 0; index_p < p.length() && index_s < s.length(); index_p++) {
            char ch = p.charAt(index_p);
            if (ch == '?'){
                index_s++;continue;
            }else if (ch == '*'){//遇到*先
                //当有很多个*连一起时等同于一个*
                while (index_p+1 < p.length() && p.charAt(index_p+1) == '*')  index_p++;
                //当这个*是字符串末尾时 true
                if (index_p == p.length()-1)    return true;
                for (int i = 0; i < s.length(); i++) {
                    if (index_s+i >= s.length())    return false;
                    if (isMatch(s.substring(index_s+i),p.substring(index_p+1)))
                        return true;
                }
                return false;
            }else if (ch != s.charAt(index_s))
                return false;
            index_s++;
        }
        for (; index_p < p.length(); index_p++) {
            if (p.charAt(index_p) != '*') return false;
        }
        if (index_p == p.length() && index_s == s.length())
            return true;
        else return false;
    }

    //可以从两头开始一起匹配，直到匹配到两头都是*（这样中间的只要按顺序存在就可以了）
    /*public boolean isMatch(String s, String p) {
        int s_start = 0;
        int p_start = 0;
        while(p_start < p.length()){
            char ch_p = p.charAt(p_start);
            if (ch_p == '*')
                break;
            else if (ch_p == '?' || ch_p == s.charAt(s_start)){
                s_start++;p_start++;
            }else return false;
        }
        //如果都直接匹配到结尾了 true
        if (p_start == p.length()){
            if (s_start == s.length())  return true;
            else return false;
        }
        int s_end = s.length()-1;
        int p_end = p.length()-1;
        while(p_end > p_start){
            char ch_p = p.charAt(p_end);
            if (ch_p == '*')    break;
            else if (ch_p == '?' || ch_p == s.charAt(s_end)){
                s_end--;p_end--;
            }else return false;
        }
        while (p_start+1 < p.length() && p.charAt(p_start+1) == '*')  p_start++;
        while (p_end-1 >= 0 && p.charAt(p_end-1) == '*')    p_end--;
        //如果p_end <= p_start 意味着p串中只有一个* 或者多个连一起 且*前后都匹配上了，返回true
        if (p_end <= p_start)   return true;
        //下面只需要看中间的是否按顺序存在过
        else {
            p_start++;
            while(p_start < p_end){
                char ch = p.charAt(p_start++);
                if (ch == '?'){
                    s_start++;
                }
                //当s串中范围在[s_start,s_end]内的数中有ch时继续循环，否则说明到结尾了也没有ch，返回false
                else if (ch != '*'){
                    while (s_start+1 <= s_end && s.charAt(s_start++) != ch);
                    if (s_start > s_end)    return false;
                }
            }
            //经过循环p中的非*?都匹配了 且子串前后位* 返回true
        }
        if (p_start == p_end)
            return true;
        else return false;
    }*/
    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("mississippi","m??*ss*?i*pi"));
    }
}
