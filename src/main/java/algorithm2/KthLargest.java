package algorithm2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 题目链接https://leetcode.com/problems/kth-largest-element-in-a-stream
 * 返回第K大的值
 * @Author: guodong
 * @Date: 2018/11/17
 */
public class KthLargest {

    private int k;
    private Queue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue(k);
        for (int num : nums) {
            this.add(num);
        }
    }

    /**
     * 添加流数据后返回第K大的值
     * @param val
     * @return
     */
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }


}
