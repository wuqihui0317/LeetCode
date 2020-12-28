/**
 * @author :wqh
 * @description :
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @create :2020-07-29 16:05:00
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy){
                buy = prices[i];
            }else if (prices[i] > buy){
                profit += prices[i]-buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
