package algorithm;

/**
 * 寻找搜索二叉树的最近公共祖先
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @Author: guodong
 * @Date: 2018/11/29
 */
public class LowestCommonAncestorOfASearchBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *
     * 递归解法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    /**
     *
     * 循环解法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorByWhile(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null){
            if(p.val<root.val && q.val<root.val){
                root =  root.left;
            }else if(p.val>root.val && q.val>root.val){
                root =  root.right;
            }else{
                return root;
            }
        }
        return root;
    }


}
