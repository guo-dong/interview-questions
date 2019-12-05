package algorithm;

/**
 * 寻找二叉树的最近公共祖先
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Author: guodong
 * @Date: 2018/11/29
 */
public class LowestCommonAncestorOfABinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        stackCount++;
        if(root != null ){
            System.out.print(root.val+"-->");
        } else{
            System.out.print("null-->");
        }

        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }


    private TreeNode ans;

    int stackCount = 0;
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        stackCount++;

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // If any two of the flags left, right or mid become True,
        // this means we have found the LCA for the nodes p and q.
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
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


        LowestCommonAncestorOfABinaryTree lca = new LowestCommonAncestorOfABinaryTree();
        //method 1

        lca.lowestCommonAncestor2(a1,a4,a5);

        //method 2
        lca.lowestCommonAncestor(a1,a4,a5);

        System.out.println();
        System.out.println(lca.stackCount);

    }




}
