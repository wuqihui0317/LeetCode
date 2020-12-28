package oneToTwenty;
/**
 * @author wub
 * LeetCode
 * 13.Roman to Integer
 * 罗马数转化为阿拉伯数字
 */
public class RomanToInteger {
    //思路：按syboml从大到小的顺序遍历s（两个字符的都在i为奇数位置）
    public int romanToInteger(String s) {
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder str = new StringBuilder(s);
        int index = 0;
        int num = 0;
        for (int i = 0; i < 13; i++) {
            if (index == str.length())
                return num;
            if (i % 2 == 0) {
                while (index + 1 <= str.length() && str.substring(index, index + 1).equals(symbol[i])) {
                    num += value[i];
                    index++;
                }
            } else if (index + 2 <= str.length() && str.substring(index, index + 2).equals(symbol[i])) {
                num += value[i];
                index += 2;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInteger("DCXXI"));
    }
}
