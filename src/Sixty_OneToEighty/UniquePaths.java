package Sixty_OneToEighty;

/**
 * @author wub
 * LeetCode
 * 62.Unique Paths
 * m*n 的格子，从左上方开始移动到右下方有几种移动方式
 */
public class UniquePaths {
    //从左上方到右下方需要m-1次右移和n-1次下移
    //实质：m-1个红球（right）和n-1个白球（down）放在一个袋子中，每次从袋子里取出一个球不放回，有几种取出方法
    //数学角度：P（先m个红球再n个白球）=1/所有取出来的方法 = (m/(m+n) * (m-1)/(m+n-1) *...* 1/(n+1))
    public int uniquePaths(int m, int n) {
        double p = 1;
        double bigger = n-1;
        double smaller = m-1;
        if (m > n){
            bigger = m-1;smaller = n-1;
        }
        while(smaller > 0){
            p *= smaller/(bigger+smaller);
            smaller -= 1;
        }
        //去除转换时的误差
        return (int)(1/p + 0.001);
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(10,10));
    }
}
