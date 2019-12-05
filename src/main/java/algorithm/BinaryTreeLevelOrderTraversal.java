package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层次遍历
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @Author: guodong
 * @Date: 2018/12/10
 */
public class BinaryTreeLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root ==  null ) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            ArrayList<Integer> currlevels = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                currlevels.add(currNode.val);
                if(currNode.left != null ){
                    queue.add(currNode.left);
                }
                if(currNode.right != null ){
                    queue.add(currNode.right);
                }
            }
            result.add(currlevels);
        }

        return result;
    }


    /**
     * DFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root ==  null ) return result;
        levelHelper(result,root,0);
        return result;
    }


    public void levelHelper(List<List<Integer>> result,TreeNode treeNode,int level){
        if (treeNode == null ) return;
        if(level>=result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(treeNode.val);
        levelHelper(result,treeNode.left,level+1);
        levelHelper(result,treeNode.right,level+1);
    }


}
