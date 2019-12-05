package algorithm;

/**
 * 反转链表
 * https://leetcode.com/problems/reverse-linked-list/
 * @Author: guodong
 * @Date: 2018/10/21
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    class Solution {

        /**
         * 反转链表方法1
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {

            ListNode reversedNode = null;
            ListNode curr = head;
            if(curr == null) return null ;

            while (curr != null){
                ListNode nextTemp = curr.next;
                curr.next = reversedNode;
                reversedNode = curr;
                curr = nextTemp;
            }
            return reversedNode;
        }

        /**
         * 反转链表方法2
         * @param head
         * @return
         */
        public ListNode reverseListMethod2(ListNode head) {
            if (head == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode pre = dummy;
            ListNode cur = head.next;
            ListNode last = head;

            while ( cur!=null ){
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = last.next;
            }
            return dummy.next;
        }


        public ListNode reverseKGroupByRecursion(ListNode head, int k) {
            ListNode curr = head;
            int count = 0;
            while(curr !=null && count !=k){
                count++;
                curr = curr.next;
            }
            if(count == k){
                curr = reverseKGroupByRecursion(curr,k);
                while(count-- > 0){
                    ListNode temp = head.next;
                    head.next = curr;
                    curr = head;
                    head = temp;
                }
                head = curr;
            }
            return head;
        }


        /**
         * 反转链表方法区间
         * @param kBegin 不含当前节点
         * @param kEnd 不含当前节点
         * @return
         */
        public ListNode reverseListPerGroup(ListNode kBegin,ListNode kEnd) {
            ListNode last = kBegin.next;
            ListNode curr = last.next;
            while (curr != kEnd){
                last.next = curr.next;
                curr.next = kBegin.next;
                kBegin.next = curr;
                curr = last.next;
            }
            return last;
        }
        
        /**
         * https://leetcode.com/problems/reverse-nodes-in-k-group/
         * @param head
         * @param k
         * @return
         */
        public ListNode reverseKGroupWithConstantExtraMemory(ListNode head, int k) {

            if(head == null || k ==1 )return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode kBegin = dummy;
            int i = 0 ;
            while(head!=null){
                i++;
                if( i % k == 0){
                    kBegin = reverseListPerGroup(kBegin,head.next);
                    head = kBegin.next;
                }else{
                    head = head.next;
                }
            }
            return dummy.next;
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
         * https://leetcode.com/problems/swap-nodes-in-pairs/
        public EasyProblems swapPairs(EasyProblems head) {
            if(head == null || head.next == null ) return head;
            EasyProblems next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }
        */

        /**
         *
         * https://leetcode.com/problems/linked-list-cycle/solution/
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null ){
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;

            while (slow != fast){
                if(fast == null || fast.next == null ){
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }

        public ListNode detectCycle(ListNode head) {

            if(head == null || head.next == null ){
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if( slow == fast){
                    while (slow != head){
                        slow = slow.next;
                        head = head.next;
                    }
                    return slow;
                }
            }
            return null;
        }


    }

    public static void main(String[] args) {
        System.out.println(1%3);
    }

}
