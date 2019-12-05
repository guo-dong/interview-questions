package algorithm;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author: guodong
 * @Date: 2019/3/5
 */
public class Test {



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(URLEncoder.encode("@","utf-8"));
    }


    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i&(i-1)]+1;
        }
        return bits;
    }

    public boolean isPowerOfTwo(int n) {
        return (n&(n-1) ) == 0;
    }
    public int hammingWeight(int n) {
        int count = 0 ;
        for (int i = 0; i < 32; i++) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }


    public static boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
    public static boolean isPerfectSquare111(int num) {
        int left = 1;
        int right = num;
        while (left<=right) {
            long mid = (left + right)/2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return false;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


}
