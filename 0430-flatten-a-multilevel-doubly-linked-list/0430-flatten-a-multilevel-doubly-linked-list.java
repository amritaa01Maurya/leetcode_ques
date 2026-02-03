/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;

        Stack<Node> st = new Stack<>();
        while(curr != null){
            if(curr.child != null){// curr node have child go to the end 
                if(curr.next != null){// store its next node to connect after we traverse from child brach
                    st.push(curr.next);
                }

                // here flatten the child branch with curr node
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            if(curr.next == null && !st.isEmpty()){// if we are at the end of child branch
                Node node = st.pop();
                curr.next = node;
                node.prev = curr;
            }

            curr = curr.next;
        }
        return head;
    }
}