import com.oracle.webservices.internal.api.EnvelopeStyle;

/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode res = newList;
        // newList = newList.next;
        while(l1 != null || l2 != null){
            if(l1 == null){
                newList = newList.next = l2;
                l2 = l2.next;
            }
            else if(l2 == null){
                newList = newList.next = l1;
                l1 = l1.next;
            }
            else{//l1 l2 both are none null
                if(l1.val <= l2.val){
                    newList = newList.next = l1;
                    l1 = l1.next;
                }
                else{
                    newList = newList.next = l2;
                    l2 = l2.next;
                }
            } 
        }
        return res.next;
    }
}
// @lc code=end

