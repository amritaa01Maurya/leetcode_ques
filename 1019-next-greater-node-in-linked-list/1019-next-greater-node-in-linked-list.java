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
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr = head;

        List<Integer> l =new ArrayList<>();

        while(curr != null){
            l.add(curr.val);
            curr = curr.next;
        }
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[l.size()];
        for(int i=l.size()-1;i>=0;i--){
            while(!st.isEmpty() && l.get(st.peek()) <= l.get(i)){
                st.pop();
            }

            ans[i] = st.isEmpty() ? 0 : l.get(st.peek());

            st.push(i);
        }
        return ans;
    }
}