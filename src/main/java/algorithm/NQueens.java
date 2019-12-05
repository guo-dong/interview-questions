package algorithm;

import java.util.*;

/**
 * N皇后问题1
 * https://leetcode.com/problems/n-queens/
 * https://leetcode.com/problems/n-queens-ii/description/
 * @Author: guodong
 * @Date: 2018/12/16
 */
public class NQueens {

    //可以用数组存boolean来加速
    Set<Integer> col = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(n,0,res,new ArrayList<String>());
        return res;
    }

    private void backtrack(int n,int row,List<List<String>> res,List<String> item){
        if (row == n) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || pie.contains(row+i) || na.contains(row-i)) continue;
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[i] = 'Q';
            item.add(new String(chars));

            col.add(i);
            pie.add(row+i);
            na.add(row-i);
            backtrack(n,row+1,res,item);

            item.remove(item.size()-1);
            col.remove(i);
            pie.remove(row+i);
            na.remove(row-i);
        }
    }


    //位运算
    int count = 0;
    public int totalNQueens(int n) {

        if (n<1) return 0;
        DFS(n,0,0,0,0);
        return count;
    }

    private void DFS(int n,int row ,int col,int pie ,int na){
        if (row>=n) {
            count++;
            return;
        }
        //得到可用空位
        int availableBits = (~(col | pie | na)) & ((1<<n)-1);
        while(availableBits != 0){
            int currBit = availableBits & -availableBits;
            DFS(n,row+1,col | currBit,(pie | currBit)<<1,(na | currBit)>>1);
            //位置不能用，清零低位1
            availableBits = availableBits & (availableBits -1);
        }

    }
}
