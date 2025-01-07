package array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #121. Best Time to Buy and Sell Stock
 * @Type: Array
 * @KeyPoint: 全局最大利润 = Max（当前卖出价格 - 局部最低成本）
 *
 * @Description: 遍历时，更新局部最小成本，并更新全局最大利润
 * @RelevantProblems: 
 */
public class _121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int curMin = prices[0];

        for(int i = 1; i < prices.length; i++) {
            // 遍历时更新局部最小成本
            if(prices[i] < curMin) {
                curMin = prices[i];
            }
            // 并更新全局最大利润
            maxProfit = Math.max(maxProfit, prices[i] - curMin);
        }

        return maxProfit;
    }
}
