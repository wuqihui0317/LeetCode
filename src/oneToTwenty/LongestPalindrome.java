package oneToTwenty;
import java.util.Scanner;

/**
 * @author wub
 * LeetCode
 * 5. Longest Palindromic Substring
 */
public class LongestPalindrome {
    //思路：遍历字符串的各个“字符”
    //      设当前字符下标为i
    //      如果后面有重复字符，可以把他们视为一个“字符”
    //      直到下标i-n与i+n的字符不同
    //      并将i与maxLen比较更新，若更大则更新最长回文串
    //      下一个字符从“字符”后开始
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0)
            return s;
        int maxLen = 1;//最长回文串的长度
        String str = s.substring(0, 1);//最长回文串
        for (int i = 0; i < len; i++) {
            int n = 1;//记录最大的两边相同的长度
            int j = i;//若有重复字符，记录重复字符的结尾
            while (j + 1 < len && s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            //下标没有越界的情况下
            while (i - n >= 0 && j + n < len) {
                if (s.charAt(i - n) == s.charAt(j + n))
                    n++;
                else break;
            }
            if (2 * n + j - i - 1 > maxLen) {
                str = s.substring(i - n + 1, j + n);
                maxLen = 2 * n + j - i - 1;
            }
            i = j;
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new LongestPalindrome().longestPalindrome(
                new Scanner(System.in).nextLine()
        ));
    }
}
