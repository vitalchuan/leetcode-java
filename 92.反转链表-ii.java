/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode pre = dummyNode, cur = head, nex = head.next;
        ListNode a, b;
        int i = 1;
        while (nex != null) {
            if (i == left) {
                a = prev;
            }
            if (i == right) {
                b = nex;
            }
            pre = cur;
            cur = nex;
            nex = nex.next;
            i++;
        }
        pre = a;
        cur = a.next;
        nex = cur.next;

        while (cur != b) {
                
        }

    }
}
// @lc code=end
