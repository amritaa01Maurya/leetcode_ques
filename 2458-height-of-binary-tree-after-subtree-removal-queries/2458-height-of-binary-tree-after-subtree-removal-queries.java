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
    int[] height = new int[100001];
    int[] level = new int[100001];
    int[] maxHeight = new int[100001]; // store the node which has max height at each level
    int[] secMaxHeight = new int[100001]; // store the node which has second max height at each level

    public int getHeight(TreeNode root){
        if(root == null){//height = longest no.of edges from root to leaf
            return -1;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        // store the height of curr node in arr
        return height[root.val] = 1 + Math.max(left, right);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        // cal height of each node in the tree
        getHeight(root);

        int m = queries.length;
        int[] ans = new int[m];

        Queue<TreeNode> q = new LinkedList<>();

        // cal the level of each node in the tree
        int l = 0;
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();

            int mxHg = -1;
            int mxHgNode = -1;
            int secmxHg = -1;
            int secmxHgNode = -1;
            while(len-- > 0){
                TreeNode curr = q.poll();
                level[curr.val] = l;// store the level of curr node in the arr
                // cal node with maxheight and secmaxHeight at each level
                if(height[curr.val] > mxHg){
                    secmxHg = mxHg;
                    secmxHgNode = mxHgNode;
                    mxHg = height[curr.val];
                    mxHgNode = curr.val;
                }else if(height[curr.val] > secmxHg){
                    secmxHg = height[curr.val];
                    secmxHgNode = curr.val;
                }

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            maxHeight[l] = mxHgNode;
            secMaxHeight[l] = secmxHgNode;
            l++;
        }


        for(int i=0;i<m;i++){
            int node = queries[i];
            // find the level of the node
            int lev = level[node];

            // now find maxheight or secmaxheight node at this level
            int nodeHeight = height[maxHeight[lev]];
            if(node == maxHeight[lev]){// if the query node is max in the level, take secmaxheight
                
                nodeHeight = secMaxHeight[lev] == -1 ? -1 : height[secMaxHeight[lev]];
            }
            ans[i] = lev + nodeHeight;
        }
        return ans;
    }
}