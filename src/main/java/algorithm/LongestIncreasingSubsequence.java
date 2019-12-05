package algorithm;

import java.util.Arrays;

/**
 * 最长上升子序列
 * 四种解法，特别推荐
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * @Author: guodong
 * @Date: 2019/1/4
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0 ) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }


    public int lengthOfLISByBS(int[] nums) {

        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp,0,len,num);
            if(i<0){
                i = -(i+1);
            }else if(i==len){
                len++;
            }
            dp[i] = num;
        }
        return len;
    }
}
