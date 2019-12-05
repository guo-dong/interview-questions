package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode.com/problems/two-sum/description/
 * @Author: guodong
 * @Date: 2018/10/19
 */
public class TwoSum {


    /**
     * MAP解法
     * 时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int k = target-nums[i];
            if(map.containsKey(k)){
                return new int[]{i,map.get(k)};
            }else {
                map.put(nums[i],i);
            }
        }

        return null;
    }




    public static void main(String[] args) {

        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
