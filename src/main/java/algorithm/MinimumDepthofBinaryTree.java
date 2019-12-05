package algorithm;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 二叉树的最小深度
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * @Author: guodong
 * @Date: 2018/12/11
 */
public class MinimumDepthofBinaryTree {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {

        if(root == null ) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0)?(left+right+1):Math.min(left,right)+1;
    }

    int min = Integer.MAX_VALUE;
    public int minDepth3(TreeNode root) {
        if(root == null ) return 0;
        helper(root,1);
        return min;
    }

    private void helper(TreeNode root,int level){
        if(root == null) return;
        if(root.left == null && root.right==null ){
            min = Math.min(level,min);
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }



    public int minDepthDFSIteration(TreeNode root) {
        if(root == null ) return 0;
        LinkedList<Pair<TreeNode,Integer>> stack = new LinkedList<>();//用的是Deque的特性，也可以使用stack
        stack.add(new Pair(root,1));
        int min = Integer.MAX_VALUE;
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.peekLast();
            TreeNode currNode = pair.getKey();
            int level = pair.getValue();
            if(currNode.left == null && currNode.right == null ) {
                min = Math.min(min,level);
            }
            if(currNode.left != null ){
                stack.add(new Pair(currNode.left,level+1));
            }
            if(currNode.right != null ){
                stack.add(new Pair(currNode.right,level+1));
            }
        }
        return min;
    }

    public static int minDepthBFSIteration2(TreeNode root) {
        if(root == null ) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curr_depth = 1;
        while(!queue.isEmpty()){
            int currLevelNodesCounts = queue.size();
            for (int i = 0; i < currLevelNodesCounts; i++) {
                TreeNode currNode = queue.poll();
                if(currNode.left == null && currNode.right == null ) {
                    return curr_depth;
                }
                if(currNode.left != null ){
                    queue.add(currNode.left);
                }
                if(currNode.right != null ){
                    queue.add(currNode.right);
                }
            }
            curr_depth++;
        }
        return curr_depth;
    }


    /**
     * 没看懂
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if(root == null ) return 0;
        if(root.left == null && root.right == null ){
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if(root.left != null ) {
            min_depth = Math.min(minDepth2(root.left),min_depth);
        }
        if(root.right != null ) {
            min_depth = Math.min(minDepth2(root.right),min_depth);
        }
        return min_depth+1;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(8);
        TreeNode a9 = new TreeNode(9);
        TreeNode a10 = new TreeNode(10);
        TreeNode a11 = new TreeNode(11);
        TreeNode a12 = new TreeNode(12);
        TreeNode a13 = new TreeNode(13);
        TreeNode a14 = new TreeNode(14);
        TreeNode a15 = new TreeNode(15);

        a1.left=a2;
        a1.right=a3;
        a2.left=a4;
        a2.right=a5;
        a3.left=a6;
        a3.right=a7;
        a4.left=a8;
        a4.right=a9;
        a5.left=a10;
        a5.right=a11;
        a6.left=a12;
        a6.right=a13;
        a7.left=a14;
        a7.right=a15;

        System.out.println(minDepthBFSIteration2(a1));
    }



}
