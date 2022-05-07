/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
import java.util.*;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Set<ListNode> hp = new HashSet<>();
        // ListNode head1 = headA;
        // ListNode head2 = headB;
        // while (head2 != null) {
        // hp.add(head2);
        // head2 = head2.next;
        // }

        // while (head1 != null) {
        // if (hp.contains(head1))
        // return head1;
        // head1 = head1.next;
        // }
        // return null;
        ListNode head1 = headA, head2 = headB;
        while (true) {
            if (head1 == null && head2 == null)
                break;
            if (head1 == head2)
                return head1;
            if (head1 == null)
                head1 = headB;
            else if (head2 == null)
                head2 = headA;
            else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return null;
    }
}
// @lc code=end
