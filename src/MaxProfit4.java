import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author :wqh
 * @description :
 * 188. 买卖股票的最佳时机 IV
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @create :2020-07-31 14:47:00
 */
public class MaxProfit4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        if (k > prices.length/2+1){
            int result = 0;
            //相当于可以无限交易
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]){
                    result += prices[i] - prices[i-1];
                }
            }
            return result;
        }
        //与MaxProfit3类似 0代表未交易
        int[] dp = new int[2*k+1];
        Arrays.fill(dp,-prices[0]);
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                int index = 2*j-1;
                //第j次买入
                dp[index] = Math.max(dp[index],dp[index-1]-prices[i]);
                //第j次卖出
                dp[index+1] = Math.max(dp[index+1],dp[index]+prices[i]);
            }
        }
        return dp[2*k];
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit4().maxProfit(2,new int[]{3,3,5,0,0,3,1,4}));
    }
}
