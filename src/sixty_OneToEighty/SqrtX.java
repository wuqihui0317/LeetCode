package sixty_OneToEighty;
/**
 * @author wub
 * LeetCode
 * 69.Sqrt(x)
 * 计算x的平方根
 * x非负整数
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        long low = 1;
        long high = x;
        while (high-low != 1){
            long mid = (low+high)/2;
            if (mid * mid < x){
                low = mid;
            }else if (mid * mid > x){
                high = mid;
            }else return (int)mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(2147395599));
    }
}
