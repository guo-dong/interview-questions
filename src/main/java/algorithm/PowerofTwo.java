package algorithm;

/**
 * 2 的幂次方
 * https://leetcode.com/problems/power-of-two/
 * @Author: guodong
 * @Date: 2018/12/29
 */
public class PowerofTwo {
    public static boolean isPowerOfTwo(int n) {
        return n>0 && ((n&(n-1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
