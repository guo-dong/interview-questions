package algorithm;

/**
 * 比特位计数
 * https://leetcode.com/problems/counting-bits/description/
 * @Author: guodong
 * @Date: 2018/12/29
 */
public class CountingBits {

    public int[] countBits(int num) {

        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i&(i-1)]+1;
        }
        return bits;
    }

    public int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
