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
    int cam = 0;
    public int solve(TreeNode root) {
        if(root == null){
            return 0;
        }
        // if it is leaf node marked -1
        if(root.left == null && root.right == null){
            return -1;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        // -1 -> leaf node
        // 0 -> no camera placed
        // 1 -> camera palced
        // if curr node children are leaf nodes, put camera there and marked it 1
        if(left == -1 || right == -1){
            cam++;
            return 1;
        }else if(left == 1 || right == 1){// if camera placed on its ledt or right, no need to place camera
            return 0;
        }
        
        return -1;
    }
    public int minCameraCover(TreeNode root) {
        // also check for root node
        if(solve(root) == -1){
            cam++;
        }

        return cam;
    }
}