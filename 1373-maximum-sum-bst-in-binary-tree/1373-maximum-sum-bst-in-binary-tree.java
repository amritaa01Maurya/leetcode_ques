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
    int maxsum = 0;
    public int[] solve(TreeNode root) {
        if(root == null){// if we are at leaf node child
            //               minleft,            maxright,         sum
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        // maxleft                minright
        if(left[1] >= root.val || right[0] <= root.val){
            return new int[]{Integer.MIN_VALUE , Integer.MAX_VALUE, 0};
        }
        int sum = left[2] + root.val + right[2];

        maxsum = Math.max(maxsum, sum);

        return new int[]{Math.min(root.val, left[0]), Math.max(root.val, right[1]), sum};

    }
    public int maxSumBST(TreeNode root) {
        solve(root);

        return maxsum;
    }
}