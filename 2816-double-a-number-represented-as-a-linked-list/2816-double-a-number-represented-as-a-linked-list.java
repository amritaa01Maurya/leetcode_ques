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
    public int solve(ListNode curr) {
        if(curr == null){
            return 0;
        }
        int val = 2 * curr.val + solve(curr.next);

        int carry = val / 10;// take carry
        int dig = val % 10;// take unit digit
        curr.val = dig;// change curr val to dig

        return carry;// return the carry for prev node
    }
    public ListNode doubleIt(ListNode head) {
        
        int carry = solve(head);
        if(carry != 0){
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }

        return head;
    }
}