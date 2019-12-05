package algorithm;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode.com/problems/coin-change/
 * @Author: guodong
 * @Date: 2019/1/6
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
                System.out.println(dp[i]);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},5));
    }
}
