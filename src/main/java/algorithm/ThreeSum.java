package algorithm;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 三数之和
 * https://leetcode.com/problems/3sum/
 * @Author: guodong
 * @Date: 2018/11/26
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length <3){
            return resultList;
        }
        Map<Integer, int[]> map = new HashMap<>();
        Arrays.sort(nums);//排序为了去重

          for (int i = 0; i < nums.length-2; i++) {

            if(i>0 && nums[i]<=nums[i-1]){//去重
                continue;
            }

            map.clear();
            for (int j = i+1; j < nums.length; j++) {

                if(map.containsKey(nums[j])){
                      resultList.add(Arrays.asList(map.get(nums[j])[0],map.get(nums[j])[1],nums[j]));
                    // 去重
                    while (j < (nums.length - 1) && nums[j] == nums[j + 1]) j++;
                }else {
                    int k = 0-(nums[i]+nums[j]);
                    map.put(k,new int[]{nums[i],nums[j]});
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(threeSum(new int[]{0,0,0,0})));
    }

}
