/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
  * 占用空间：flag,prev,end,newHead,可见额外空间为常数空间
  */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        boolean flag = true;
        ListNode prev = new ListNode(0);
        ListNode res = prev;
        prev.next = head;
        while(head != null){
            ListNode end = head;
            for(int i = 0;i < k-1; i++){
                end = end.next;
                if(end == null){
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            ListNode newHead = end.next;

            //断链
            end.next = null;
            prev.next = reverse(head);
            head.next = newHead;
            prev = head;
            head = newHead;
        }
        return res.next;
    }

    /**
     * 占用常数的额外空间，只需要prev,curr,next三个变量
     * @param head
     * @return  reverse后的头结点
     */
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
// @lc code=end

