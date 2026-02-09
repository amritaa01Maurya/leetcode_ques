/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        int l = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len =q.size();
            List<TreeNode> ll = new ArrayList<>();

            // push nodes children in q
            for(int i=0;i<len;i++){
                TreeNode curr = q.poll();
                // add curr level nodes in list
                ll.add(curr);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            // if curr level is odd , then reverse the val only
            if(l % 2 != 0){
                int size=ll.size();
                int i =0;
                int j = size - 1;
                // reverse the val
                while(i <= j){
                    TreeNode left = ll.get(i);
                    TreeNode right = ll.get(j);
                    int temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                    i++;
                    j--;
                }
            }
            l++;
        }
        return root;
    }
}