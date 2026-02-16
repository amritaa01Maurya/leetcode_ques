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
    public boolean solve(TreeNode node, int min, int max, Map<Integer, TreeNode> map) {
        if(node == null){
            return true;
        }

        if(node.val <= min || node.val >= max){
            return false;
        }

        if(node.left != null && map.containsKey(node.left.val)){
            TreeNode temp = map.remove(node.left.val);
            node.left = temp;
        }

        if(node.right != null && map.containsKey(node.right.val)){
            TreeNode temp = map.remove(node.right.val);
            node.right = temp;
        }
        return solve(node.left, min, node.val, map) && solve(node.right, node.val, max, map);
    }
    public TreeNode canMerge(List<TreeNode> trees) {
        HashSet<Integer> leaf = new HashSet<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        
        // set of leave
        for(TreeNode node:trees){
            TreeNode root = node;
            map.put(root.val, root);
            if(root.left != null){
                leaf.add(root.left.val);
            }
            if(root.right != null){
                leaf.add(root.right.val);
            }
        }

        // find our main root
        TreeNode mainRoot = null;

        for(TreeNode node:trees){
            if(!leaf.contains(node.val)){
                if(mainRoot == null){
                    mainRoot = map.remove(node.val);
                }else{
                    return null;
                }
            }
        }

        if(mainRoot == null){
            return null;
        }
        
        if(solve(mainRoot, 0, 500001, map)){
            if(map.size() != 0){
                return null;
            }
            return mainRoot;
        }


        return null;
    }
}