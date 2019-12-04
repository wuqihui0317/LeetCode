package OneToTwenty;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 17.Letter Combination Of a Phone Number
 * 九宫格键盘，按数字键后可能出现的字母组合
 */
public class LetterCombinationOfAPhoneNumber {
    //递归
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            fun("", digits);
        return result;
    }

    //递归函数
    public void fun(String combination, String nextDigits) {
        if (nextDigits.equals("")) {
            result.add(combination);
            return;
        }
        int digit = nextDigits.charAt(0) - '0' - 1;
        for (int i = 0; i < pn[digit].length; i++) {
            fun(combination + pn[digit].alphabet[i], nextDigits.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationOfAPhoneNumber().letterCombinations("29"));
    }

    PhoneNumber pn[] = PhoneNumber.values();

    enum PhoneNumber {
        one(), two('a', 'b', 'c'), three('d', 'e', 'f'),
        four('g', 'h', 'i'), five('j', 'k', 'l'), six('m', 'n', 'o'),
        seven('p', 'q', 'r', 's'), eight('t', 'u', 'v'), night('w', 'x', 'y', 'z');
        private Character[] alphabet = new Character[4];
        int length;

        PhoneNumber(char... chars) {
            int i = 0;
            for (char ch : chars)
                alphabet[i++] = ch;
            length = i;
        }
    }
}
