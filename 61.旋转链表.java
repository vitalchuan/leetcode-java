/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode tail = null;
        ListNode tmp = head;

        if(head == null){
            return null;
        }
        while (tmp != null) {
            if (tmp.next == null)
                tail = tmp;
            tmp = tmp.next;
            len++;
        }
        k = k % len;

        if (k == 0)
            return head;

        ListNode end = get(head, len - k - 1);
        ListNode start = get(head, len - k);
        end.next = null;
        tail.next = head;

        return start;
    }

    public ListNode get(ListNode head, int index) {
        for (int i = 1; i <= index; i++) {
            head = head.next;
        }
        return head;
    }
}
// @lc code=end
