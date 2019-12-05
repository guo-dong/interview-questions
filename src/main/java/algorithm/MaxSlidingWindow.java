package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *https://leetcode.com/problems/sliding-window-maximum/
 * @Author: guodong
 * @Date: 2018/11/18
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length ==0 || k<=0){
            return new int[0];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if(!dq.isEmpty() && dq.peek()<i-k+1){
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offer(i);

            if(i>=k-1){
                res[j++] = nums[dq.peek()];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        MaxSlidingWindow m = new MaxSlidingWindow();
        int[] ints = m.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }
    }

}
