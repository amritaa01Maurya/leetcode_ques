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
    public TreeNode solve(TreeNode root, int target) {
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            if(root.val == target){
                return null;
            }
            return root;
        }
        TreeNode left = solve(root.left, target);
        TreeNode right = solve(root.right, target);

        root.left = left;
        root.right = right;

        return (root.left == null && root.right == null && root.val == target) ? null : root;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return solve(root, target);
    }
}