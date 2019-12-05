package algorithm;

/**
 * 乘积最大子序列
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * @Author: guodong
 * @Date: 2019/1/3
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if( nums == null) return 0;
        int[][] dp = new int[2][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
           int x = i%2,y = (i-1)%2;
           dp[x][0] = Math.max( Math.max(dp[y][0]*nums[i],dp[y][1]*nums[i]),nums[i] );
           dp[x][1] = Math.min( Math.min(dp[y][0]*nums[i],dp[y][1]*nums[i]),nums[i] );
           res = Math.max(res,dp[x][0]);
        }
        return res;
    }

    public int maxProductByRecursion(int[] nums) {
        if( nums == null) return 0;

        return 1;
    }

}
