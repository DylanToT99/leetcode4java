package DynamicPrograming;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/17 14:05
 * @description 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 518. 零钱兑换 II
 **/
public class change_ {
    public int change(int amount, int[] coins) {
        int[]dp=new int[amount+1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
    @Test
    public void test(){
        System.out.println(change(6, new int[]{1, 2, 3, 4, 5, 6}));
    }
}
