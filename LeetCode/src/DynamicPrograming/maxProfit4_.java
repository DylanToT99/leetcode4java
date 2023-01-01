package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/28 11:31
 * @description 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 **/
public class maxProfit4_ {
    public int maxProfit(int k, int[] prices) {
        /**
         * 偶数代表卖出,奇数代表买入
         */

        int[][]dp=new int[prices.length][2*k+1];
        //第0天的状态
        for (int i = 1; i < 2*k; i+=2) {
            dp[0][i]=-prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <2*k-1 ; j+=2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length-1][2*k];
    }
}
