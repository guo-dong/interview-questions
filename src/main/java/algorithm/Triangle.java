package algorithm;

import java.util.List;

/**
 * 三角相邻路径最小和
 * https://leetcode.com/problems/triangle/description/
 * @Author: guodong
 * @Date: 2019/1/1
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        List<Integer> minLevel =  triangle.get(triangle.size()-1);
        for (int i = triangle.size()-2; i >=0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                minLevel.set( j,( triangle.get(i).get(j)+Math.min(minLevel.get(j),minLevel.get(j+1)) ) );
            }
        }
        return minLevel.get(0);
    }
}
