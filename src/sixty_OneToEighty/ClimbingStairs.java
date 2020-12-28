package sixty_OneToEighty;
/**
 * @author wub
 * LeetCode
 * 70.Climbing Stairs
 * 爬楼梯，每次只能爬1格或者两个
 * 有多少种方法可以爬上n格楼梯（n为正整数）
 */
public class ClimbingStairs {
    //n个1 ~ n/2个2 n%2个1
    //0个2时一种可能（0个2放在n个1间） P = 1
    //1个2时n-1种可能（1个2放在n-2个1间） P(先1个2再n-2个1) = 1/所有 = 1/（n-1）
    //2个2时（2个2放在n-4个1中间） P = 1/(2/(n-2)*(1/(n-3))
    //。。。
    //n/2个2放在n%2个1中间
    public int climbStairs(int n) {
        int result = 0;
        for (int i = 0; i <= n/2; i++) {
            int j = n-2*i;//i为2的个数，j为1的个数
            if (i < j)
                result += function(i,j);
            else result += function(j,i);
        }
        return result;
    }
    //计算m个红球和n个白球 所有可能的组合
    public int function(double m,double n){
        double p = 1;
        while (m != 0){
            p *= m/(m+n);
            m -= 1;
        }
        p = 1/p;
        return (int)(p+0.000001);
    }
}
