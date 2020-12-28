/**
 * @author :wqh
 * @description :
 * @create :2020-07-20 17:37:00
 */

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        if (prices.length < 1){
            return 0;
        }
        //0 未交易
        //1 买了一次
        //2 卖了一次
        //3 买了两次
        //4 卖了两次
        int[] dp = new int[5];

        dp[0] = 0;
        dp[1] = -prices[0];
        dp[3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[1],dp[0]-prices[i]);
            dp[2] = Math.max(dp[2],dp[1]+prices[i]);
            dp[3] = Math.max(dp[3],dp[2]-prices[i]);
            dp[4] = Math.max(dp[4],dp[3]+prices[i]);
        }
        return dp[4];
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit3().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
