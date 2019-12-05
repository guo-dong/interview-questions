package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 取众数
 * https://leetcode.com/problems/majority-element/description/
 * @Author: guodong
 * @Date: 2018/12/7
 */
public class MajorityElement {


    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static int majorityElement2(int[] nums) {
        int half = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            if(!map.containsKey(n)){
                map.put(n,1);
            }else {
                map.put(n,map.get(n)+1);
            }
            if(map.get(n)>half){
                return n;
            }
        }
        return -1;
    }

    public static int majorityElement3(int[] nums) {
        int major = nums[0];
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else {
                count-- ;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement3(new int[]{3,1,1,3,2,10,3,3,5,3,1,2,3,3,3,3}));
    }
}
