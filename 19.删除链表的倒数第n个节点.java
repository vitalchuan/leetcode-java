import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map = new HashMap<>();
        int i=0;
        while(head != null)
        {
            map.put(i++,head);
            head = head.next;
        }
        int len = i;
        if(len == n)
            return map.get(1);
        map.get(len - n -1).next = map.get(len - n +1);
        return map.get(0);
    }
}
// @lc code=end

