package algorithm;

/**
 * 计算平方根
 * https://leetcode.com/problems/sqrtx/
 * @Author: guodong
 * @Date: 2018/12/26
 */
public class Sqrtx {

    public static int mySqrtByBinarySearch(int x) {

        if (x == 0 ) return 0;
        int left = 1 ;
        int right = x;
        int res = 0;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(mid == x/mid ){
                return mid;
            }else if(mid> x/mid ){
                right = mid -1;
            }else {
                left = mid +1;
                res = mid;
            }
        }
        return res;
    }


    public static int mySqrtByNewton(int x) {

        if (x == 0 ) return 0;
        long res = x;
        while (res>x/res){
            res = (res+x/res)/2;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrtByNewton(4));
    }

}
