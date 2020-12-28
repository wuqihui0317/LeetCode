package forty_OneToSixty;

/**
 * @author wub
 * LeetCode
 * 58.LengthOfLastWord
 * 返回语句字符串的最后一个单词的长度
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int end = s.length()-1;//倒数第一个字符（非空格）
        while (end != -1 && s.charAt(end) == ' ')    end--;
        if (end == -1)  return 0;
        int blankIndex;
        //blankIndex为倒数第一个空格的下标或者-1
        for (blankIndex = end; blankIndex != -1 && s.charAt(blankIndex) != ' '; blankIndex--);
        return end - blankIndex;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("hello world"));
    }
}
