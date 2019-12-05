package algorithm;

/**
 *
 * https://leetcode.com/problems/number-of-1-bits/
 * @Author: guodong
 * @Date: 2018/12/28
 */
public class Numberof1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((n & mask) != 0){
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
