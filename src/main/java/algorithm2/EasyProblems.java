package algorithm2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 反转链表
 * https://leetcode.com/problems/reverse-linked-list/
 * @Author: guodong
 * @Date: 2018/10/21
 */
public class EasyProblems {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    /**
     * 反转单链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null ) return null;

        ListNode reversedNode = null;
        ListNode curr = head;

        if (curr != null) {
            ListNode temp = curr.next;
            curr.next = reversedNode;
            reversedNode = curr;
            curr = temp;
        }

        return reversedNode;
    }

    /**
     * https://leetcode.com/problems/swap-nodes-in-pairs/
     * 递归交换，很好理解
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode third = second.next;

        second.next = first;
        first.next = swapPairs(third);

        return second;
    }

    /**
     * 校验括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        if(s==null || "".equals(s)){
            return true;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if ( !stack.empty() && stack.peek().equals(map.get(c))) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    /**
     * 最长回文字符串
     * @param s
     * @return
     */
    private int start, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(start, start + maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            start = left + 1;
            maxLen = right - left - 1;
        }
    }


    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串
     * https://leetcode-cn.com/problems/valid-palindrome-ii/
     * @param s
     * @return
     */
    public boolean validPalindrome2(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
            }
        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r){
            if (s.charAt(l) != s.charAt(r)) return false;
        }
        return true;
    }

    /**
     * 有效字母异位词
     * https://leetcode.com/problems/valid-anagram/
     * @Author: guodong
     * @Date: 2018/11/27
     */
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length()!=t.length()){
            return  false;
        }
        int[] tab = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ti = t.charAt(i) - 'a';
            int ji = s.charAt(i) - 'a';
            tab[ti] ++;
            tab[ji] --;
        }
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] != 0) return false;
        }
        return true;
    }

    /**
     * Group Anagrams
     * https://leetcode.com/problems/group-anagrams/
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }


    /**
     * 两数之和
     * https://leetcode.com/problems/two-sum/description/
     * @Author: guodong
     * @Date: 2018/10/19
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length<2){
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int k = target-nums[i];
            if (map.containsKey(k)) {
                return new int[]{i,map.get(k)};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }

    /**
     * 三数之和
     * https://leetcode.com/problems/3sum/
     * @Author: guodong
     * @Date: 2018/11/26
     */
    public List<List<Integer>> threeSum(int[] nums) {
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


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 校验二叉搜索树
     * @param root
     * @return
     */
    TreeNode prev =null;// 中序遍历这棵树，并保存前驱节点至prev中
    public boolean isValidBST(TreeNode root){
        if (root == null ) return true;
        if(!isValidBST(root.left)){
            return false;
        }
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }

    /**
     * 寻找二叉树的最近公共祖先
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * @Author: guodong
     * @Date: 2018/11/29
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

    /**
     * 寻找搜索二叉树的最近公共祖先
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * @Author: guodong
     * @Date: 2018/11/29
     */
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val<root.val && q.val<root.val) {
            return lowestCommonAncestorBST(root.left,p,q);
        }else if(p.val>root.val && q.val> root.val){
            return lowestCommonAncestorBST(root.right,p,q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestorBST2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (p.val<root.val && q.val<root.val) {
                root = root.left;
            }else if(p.val>root.val && q.val> root.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return root;
    }

    /**
     * 取众数
     * https://leetcode.com/problems/majority-element/description/
     * @Author: guodong
     * @Date: 2018/12/7
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 给定一个整数数组nums，找到具有最大和的连续子数组（至少包含一个数字）并返回其和。
     * https://leetcode.com/problems/maximum-subarray/
     * @param A
     * @return
     */
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 爬楼梯斐波那契数列
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n<=2) return n;
        int lastStep = 0;
        int preStep=2;
        int prePreStep=1;
        for (int i = 2; i < n; i++) {
            lastStep = preStep + prePreStep;
            prePreStep = preStep;
            preStep = lastStep;
        }
        return lastStep;
    }
    /**
     * 爬楼梯，正宗dp
     * @param n
     * @return
     */
    public int climbStairs正宗DP(int n) {
        if(n<=2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
    /**
     * 二叉树的最大深度
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     * @Author: guodong
     * @Date: 2018/12/10
     */
    public int maxDepth(TreeNode root) {
        if(root == null ) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    int result = 1;
    public int maxDepth2(TreeNode root) {
        if(root == null ) return 0;
        levelHelper(root,1);//注意这里是1不是0
        return result;
    }

    private void levelHelper(TreeNode root, int level) {
        if(root == null ) return;
        if(level>result){
            result = level;
        }
        levelHelper(root.left,level+1);
        levelHelper(root.right,level+1);
    }

    /**
     * 二叉树的最小深度
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
     * @Author: guodong
     * @Date: 2018/12/11
     */
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null ) return 0;
        levelHelperMinDepth(root,1);
        return minDepth;
    }

    private void levelHelperMinDepth(TreeNode root, int level) {
        if (root == null ) return;
        if(root.left == null && root.right==null ){
            minDepth = Math.min(level,minDepth);
        }
        levelHelperMinDepth(root.left,level+1);
        levelHelperMinDepth(root.right,level+1);
    }

    public static int minDepthBFSIteration(TreeNode root) {
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
     * 二分查找(从小到大的排序)
     * @Author: guodong
     * @Date: 2018/10/10
     */
    public int binarySearch(int[] arr,int key) {

        int left=0,right = arr.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (key<arr[mid]) {
                right = mid-1;
            }else if(key>arr[mid]){
                left = mid+1;
            }else {
                return arr[mid];
            }
        }
        return -1;
    }

    /**
     *
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if(nums == null || nums.length==1 ) return -1;
        if( nums.length==1 ) return nums[0];

        int left = 0,right = nums.length-1;
        while (left < right){
            if(nums[left]<nums[right]) return nums[left];

            int mid = left + (right-left)/2;
            if (nums[mid]<nums[right]) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return nums[left];
    }

    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


    /**
     * 互为镜像2叉数
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    public static void main(String[] args) {

        String str = "hello";
        test(str);
        System.out.println(str);
    }

    public static void test(String str){
        str = str + "world";
        String s = new String(str);
        System.out.println(str);
        int[] a = new int[1024];
    }



}
