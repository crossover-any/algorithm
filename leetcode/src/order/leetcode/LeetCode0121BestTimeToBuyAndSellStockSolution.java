package order.leetcode;

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author tengxq
 */
public class LeetCode0121BestTimeToBuyAndSellStockSolution {
    public static void main(String[] args) {

    }

    /**
     * 思路：暴力破解，假设在第m天买（卖）股票,在n天卖（卖）收益最大
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param prices 股价数组
     * @return 最大收益
     */
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length -1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }

    /**
     * 思路：将问题分割成最小单位
     *      第一天：只能买到股票
     *      第二天：如果当日股价比购入价高，售出可获得收益
     *             如果当日股价比购入价低，我们应该在该日购入股票，无收益
     *      第n天：同n-1天
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param prices 股价数组
     * @return 最大收益
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int price : prices) {
            if (price < buyPrice) {
                buyPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - buyPrice);
            }
        }
        return maxProfit;
    }
}
