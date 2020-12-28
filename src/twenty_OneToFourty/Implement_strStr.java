package twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 28.Implement strStr()
 * 找出haystack串中needle子串的第一个字符的index
 * 用substring()遍历haystack字符串
 */
public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for (int i = 0; i < haystack.length()-len+1; i++) {
            if (needle.equals(haystack.substring(i,i+len)))
                return i;
        }
        return -1;
    }
}
