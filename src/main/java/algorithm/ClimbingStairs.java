package algorithm;

/**
 * 爬楼梯(5中解法)，举一反三，多思考
 * https://leetcode.com/problems/climbing-stairs/description/
 * @Author: guodong
 * @Date: 2019/1/1
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n<=2) return n;
        int lastStep = 0;
        int preStep=2;
        int prePreStep=1;
        for (int i = 2; i < n; i++) {
            lastStep = preStep + prePreStep;
            prePreStep = preStep;
            preStep = lastStep;
        }
        return lastStep;
    }

    public int climbStairs正宗DP(int n) {
        if(n<=2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1]+dp[i+1];
        }
        return dp[n-1];
    }

}
