/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode prev = dummyNode;
        ListNode current = head;

        while (current.next != null) { // 只要没到结尾
            if (current.val != current.next.val)
                current = current.next;
            else {
                while (current.val == current.next.val) {
                    current = current.next;
                    if (current.next == null) {// 遇到重复的直到结尾 直接返回
                        prev.next = current;
                        return dummyNode.next;
                    }
                }
            }
        }
    }
}
// @lc code=end
