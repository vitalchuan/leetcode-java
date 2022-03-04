import java.util.*;
/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        List<ListNode> list = new ArrayList<>();
        
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode[] nodeArr = list.toArray(new ListNode[list.size()]);

        for(int i = 1; i < nodeArr.length; i++){
            for(int j = i; j > 0; j--){
                if(nodeArr[j-1].val > nodeArr[j].val){
                    ListNode tmp = nodeArr[j];
                    nodeArr[j] = nodeArr[j-1];
                    nodeArr[j-1] = tmp;
                }
            }
        }

        for(int i = 0; i < nodeArr.length - 1; i++)
            nodeArr[i].next = nodeArr[i+1];
        nodeArr[nodeArr.length-1].next = null;
        return nodeArr[0];
        
    }
}
// @lc code=end
