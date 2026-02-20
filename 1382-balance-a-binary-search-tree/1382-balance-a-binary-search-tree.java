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
    List<Integer> ll = new ArrayList<>();
    public TreeNode build(int l, int r){
        
        if(l > r){
            return null;
        }

        int mid = (l+r)/2;

        TreeNode root = new TreeNode(ll.get(mid));

        TreeNode left = build(l, mid-1);
        TreeNode right = build(mid+1, r);

        root.left = left;
        root.right = right;

        return root;
    }
    public void inorder(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        ll.add(root.val);
        inorder(root.right);
    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);

        int l = 0;
        int r = ll.size()-1;
        
        return build(l, r);
    }
}