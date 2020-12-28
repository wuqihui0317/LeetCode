package forty_OneToSixty;
/**
 * @author wub
 * LeetCode
 * 50.Pow(x,n)
 * 实现x^n，double x，int n
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0 || x == 1) return 1;
        boolean negative = false;
        if (n < 0){
            n = -n;
            negative = true;
        }
        x = pow(x,n);
        if (negative)   x = 1/x;
        return x;
    }
    public double pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        double temp = x;
        long i = 2;
        while (i < n){
            x *= x;
            i *= 2;
        }
        i /= 2;
        if (i == n) return x;
        else return x * pow(temp , n - (int)i);
    }

    //大佬的解法
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow1(x, n / 2);
        double rest = myPow1(x, n % 2);
        return half * half * rest;

    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(0.00001 , 2147483647));
    }
}
