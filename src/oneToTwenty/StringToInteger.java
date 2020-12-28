package oneToTwenty;
/**
 * @author wub
 * LeetCode
 * 8.String to Integer
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;
        int i;//记录第一个数字的下标
        long result;
        boolean mark = false;
        //先找到第一个不是空格的字符下标
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.charAt(i) != '0')
                break;
            if (mark && str.charAt(i) == ' ')
                return 0;
            if (str.charAt(i) == '0')
                mark = true;
        }
        if (i == str.length())
            return 0;
        if (mark && (str.charAt(i) == '-' || str.charAt(i) == '+'))
            return 0;
        boolean negative = false;
        //判断是整数还是复数
        if (str.charAt(i) != '-' && (str.charAt(i) < '0' || str.charAt(i) > '9') && str.charAt(i) != '+') {
            return 0;
        } else if (str.charAt(i) == '-') {
            negative = true;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        for (; i < str.length(); i++) {
            if (str.charAt(i) != '0')
                break;
        }
        int j;//记录最后一个数字下标
        for (j = i; j < str.length(); j++) {
            //当j下标不是数字时 中断，j的下标仍为数字下标
            if (str.charAt(j) < '0' || str.charAt(j) > '9')
                break;
        }
        if (i == j)
            return 0;
        if (j - i >= 11)
            if (negative)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        result = Long.parseLong(str.substring(i, j));

        //负数情况
        if (negative) {
            if (-result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int) -result;
        }
        //正数情况
        else {
            if (result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return (int) +result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("0   123"));
    }
}
