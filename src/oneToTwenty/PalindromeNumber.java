package oneToTwenty;
/**
 * @author wub
 * LeetCode
 * 9.Palindrome number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x == 0)
            return true;
        int reverse = 0;
        int y = x;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        if (reverse == y)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(121));
    }
}
