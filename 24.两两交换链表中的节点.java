import java.util.*;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode zero = new ListNode(0);
        ListNode res = zero;
        zero.next = head;
        int i = 1;
        Map<Integer,ListNode> map = new HashMap<>();
        map.put(0,zero);
        while(head != null){
            map.put(i++,head);
            head = head.next;
        }
        for(int j = 2;j <= i-1; j += 2){
            ListNode firstNode = map.get(j-2);
            ListNode secondNode = map.get(j-1);
            ListNode thirdNode = map.get(j);
            firstNode.next = thirdNode;
            secondNode.next = thirdNode.next;
            thirdNode.next = secondNode;
            map.put(j-1,thirdNode);
            map.put(j,secondNode);
        }
        return res.next;
    }
}
// @lc code=end

