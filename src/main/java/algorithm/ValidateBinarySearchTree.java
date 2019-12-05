package algorithm;

import java.util.Stack;

/**
 *
 * 校验是否为二叉搜索树
 * @Author: guodong
 * @Date: 2018/12/2
 */
public class ValidateBinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val)) return false;
        return helper(root.left, min, root) && helper(root.right, root, max);
    }


    public boolean isValidBSTByInorderTraversal(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre =  null;
        while (root != null || !stack.isEmpty()){
            while (root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val<=pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    TreeNode prev =null;// 中序遍历这棵树，并保存前驱节点至prev中
    public boolean isValidBST2(TreeNode root){

        if(root == null) return true;
        if(!isValidBST2(root.left)) return false;

        if(prev != null && prev.val>=root.val) return false;
        prev = root;

        if(!isValidBST2(root.right)) return false;


        return true;
    }
}
