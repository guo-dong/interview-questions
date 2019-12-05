package algorithm;

import java.util.PriorityQueue;

/**
 * 题目链接https://leetcode.com/problems/kth-largest-element-in-a-stream
 * @Author: guodong
 * @Date: 2018/11/17
 */
public class KthLargest {

    private final PriorityQueue<Integer> pq;
    private final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
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
        if (pq.size()>k){
            pq.poll();
        }
        System.out.println("after add,the min top is:"+pq.peek());
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);

    }




}
