package twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 29.Divide Two Integers
 * 两数相除，返回去除小数点后的整数值，要求不能使用乘除和mod运算符
 * 思路：先记录除数和被除数的符号是否相同，然后取负做减法运算
 * 由于负数区间较大，选择统一使用负数进行减法运算
 */
public class DivideTwoIntegers {
    public int divide(int dividend,int divisor){
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean sign_unique = false;
        if (dividend < 0){
            sign_unique = !sign_unique;
        }else   dividend = -dividend;
        if (divisor < 0){
            sign_unique = !sign_unique;
        }else   divisor = -divisor;
        int result = backtrack(dividend,divisor);
        return sign_unique?-result:result;
    }
    //回溯
    public int backtrack(int dividend,int divisor){
        if (dividend > divisor) return 0;
        int divisor1 = divisor;
        int result = 1;
        dividend -= divisor;
        while (dividend <= divisor){
            dividend -= divisor;
            divisor += divisor;
            result += result;
        }
        return result+backtrack(dividend,divisor1);
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(100,2));
    }
}
