/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */
// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev, current, next;
        current = head;
        ListNode dummyNode = new ListNode(0, head);
        prev = dummyNode;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                while (current.val == current.next.val) { // 找到下一个不同的点
                    current = current.next;
                    if (current.next == null) { // 遇到结尾，直接return
                        current = null;
                        prev.next = null;
                        return dummyNode.next;
                    }
                }

                current = current.next;
                prev.next = current; // 删除中间节点
            } else {
                prev = current;
                current = current.next;
            }
        }
        return dummyNode.next;
    }
}
// @lc code=end
