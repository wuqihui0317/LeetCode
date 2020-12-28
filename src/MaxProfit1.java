/**
 * @author :wqh
 * @description :
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 * @create :2020-07-29 16:02:00
 */
public class MaxProfit1 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int result = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else {
                result = result>prices[i]-min?result:prices[i]-min;
            }
        }
        return result;
    }
}
