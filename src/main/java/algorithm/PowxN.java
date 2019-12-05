package algorithm;

/**
 * https://leetcode.com/problems/powx-n/description/
 * 求X的N次幂
 * @Author: guodong
 * @Date: 2018/12/5
 */
public class PowxN {

    public static void main(String[] args) {

//        System.out.println(myPow2(2.1,3));
//        System.out.println(myPow(Double.MAX_VALUE,-2147483));
//        System.out.println(myPow(2,8));
//        System.out.println(pow1(2,10));
        System.out.println(myPowByIter(2,10));
    }
    public  static double myPow(double x, int n) {
        if (0 == n) {
            return 1;
        } else if(n==Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n<0) {
            x = 1/x;
            n = -n;
        }

        if (n % 2 == 0) {
            double v = myPow(x * x,n/2);
            return v;
        } else {
            double v = x * myPow(x * x,n/2);
            return v;
        }
    }

    public  static double myPow2(double x, int n) {
        if(n == 0 ) return 1;
        else if(n==Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n<0) {
            x = 1/x;
            n = -n;
        }
        return recursion(x,n);
    }

    private static double recursion(double x, int n) {
        if(n == 0 ) return 1;
        if(n%2 == 0){
            return recursion(x*x, n/2);
        }
        return x * (recursion(x*x,n/2));//
    }

    public static double  myPowByIter(double x, int n){
        if (0 == n) return 1;
        if(n==Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n<0) {
            x = 1/x;
            n = -n;
        }
        double rs = 1;
        while (n!=0){
            if((n&1)==1) rs = rs*x;
            x = x*x;
            n = n >> 1;
        }
        return rs;
    }

}
