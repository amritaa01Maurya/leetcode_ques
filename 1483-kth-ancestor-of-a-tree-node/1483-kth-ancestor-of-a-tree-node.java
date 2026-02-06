class TreeAncestor {
    int[][] par;
    public TreeAncestor(int n, int[] parent) {
        par = new int[17][n];

        for(int i=0;i<n;i++){
            par[0][i] = parent[i];// 0th ancestor of each node
        }

        // cal 1 to 16th par to each node
        for(int k=1;k<17;k++){
            for(int i=0;i<n;i++){
                int prevParNode = par[k-1][i];// find the prev par (k-1) of ith node
                par[k][i] = prevParNode == -1 ? -1 : par[k-1][prevParNode];// now find (k-1) th par of (ith prev parent node)
            }
        }
        //      0    1   2   3   4   5   6
//  2^0   0    -1    0   0   1   1   2   2
//  2^1   1    -1   -1  -1   0   0   0   0
//  2^2   2    -1   -1  -1  -1  -1  -1  -1

    }
    
    public int getKthAncestor(int node, int k) {
        // [5,2]
        // k = 2 = 10
        for(int i=0;i<17 && node != -1;i++){
            int mask = (1 << i);// 1 ;; 10
            if((k & mask) != 0){ // 10 & 1 == 0 ;; 10 & 10 == 1
                //     par[1][5] = 
                node = par[i][node];// ith par of node 
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */