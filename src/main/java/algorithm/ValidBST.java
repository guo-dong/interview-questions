package algorithm;

/**
 * @Author: guodong
 * @Date: 2019/2/27
 */
public class ValidBST {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return help(root,null,null);
    }

    private static boolean help(TreeNode root, TreeNode min, TreeNode max) {

        System.out.println((root==null?"null":root.val)+" ,"+(min==null?"null":min.val)+" ,"+(max==null?"null":max.val));

        if(root == null ) return true;
//        System.out.print(root.val+"-->");
//        if (min != null ) System.out.println(root.val+" <="+min.val);

        if (min != null && root.val <= min.val) {
            return false;
        }
//        if (max != null ) System.out.println(root.val+" >="+max.val);
        if (max != null && root.val >= max.val) {
            return false;
        }


        boolean left = help(root.left,min,root);
        boolean right = help(root.right ,root,max);
        return left && right;

    }


    public static boolean isValidBSTByInorderTraversal (TreeNode root) {

        return false;
    }


    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(9);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(10);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(14);
        TreeNode a7 = new TreeNode(4);
        TreeNode a8 = new TreeNode(7);
        TreeNode a9 = new TreeNode(13);
        TreeNode a10 = new TreeNode(8);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.right = a6;
        a5.left = a7;
        a5.right = a8;
        a6.left = a9;
        a8.right = a10;

        System.out.println(isValidBST(a1));

    }


    /**
     * 校验二叉搜索树
     * @param root
     * @return
     */
    TreeNode prev =null;// 中序遍历这棵树，并保存前驱节点至prev中
    public boolean isValidBST2(TreeNode root){
        if(root == null) return true;
        if(!isValidBST2(root.left)){
            return false;
        }
        if(prev!=null && root.val<=prev.val){
            return false;
        }
        prev = root;
        return isValidBST2(root.right);
    }



}
