/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // if less than k nodes left
        ListNode temp = head;
        int m = 0;
        while(m++ < k){
            if(temp == null){
                return head;
            }
            temp = temp.next;
        }

        m = 0;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(m++ < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKGroup(next, k);

        return prev;
    }
}