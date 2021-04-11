/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small, large, current, smallDummy, largeDummy;
        current = head;
        
        smallDummy = new ListNode();
        largeDummy = new ListNode();

        small = smallDummy;
        large = largeDummy;

        while (current != null) {
            if (current.val < x) {
                // 将current节点接入small后面
                small.next = current;
                small = small.next;
            } else {
                large.next = current;
                large = large.next;
            }

            current = current.next;
        }

        small.next = largeDummy.next;
        large.next = null;
        return smallDummy.next;
    }
}
// @lc code=end
