import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;

        // 自顶向下得归并排序
        ListNode tail = head;
        while (tail.next != null)
            tail = tail.next;
        return sortList(head, tail);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == tail)
            return head;
        if (head.next == tail) {
            if (head.val > tail.val) {
                tail.next = head;
                head.next = null;
                return tail;
            } else
                return head;
        }

        // 快慢指针找到中间节点
        ListNode fast = head, slow = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail)
                fast = fast.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        ListNode left = sortList(head, slow);
        ListNode right = sortList(head2, tail);
        return merge(left, right);

    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode head1 = head;

        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                head = head.next;
                left = left.next;
            } else {
                head.next = right;
                head = head.next;
                right = right.next;
            }
        }

        if (left != null)
            head.next = left;
        else if (right != null)
            head.next = right;
        return head1.next;
    }
}
// @lc code=end
