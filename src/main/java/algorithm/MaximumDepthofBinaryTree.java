package algorithm;

import java.util.LinkedList;

/**
 * 二叉树的最大深度
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @Author: guodong
 * @Date: 2018/12/10
 */
public class MaximumDepthofBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if(root == null ) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


    int result = 1;
    public int maxDepthDFS(TreeNode root) {
        if(root == null ) return 0;
        levelHelper(root,1);
        return result;
    }

    public void levelHelper(TreeNode treeNode,int level){
        if (treeNode == null ) return;
        if(level>this.result){
            this.result = level;
        }
        levelHelper(treeNode.left,level+1);
        levelHelper(treeNode.right,level+1);
    }



}
