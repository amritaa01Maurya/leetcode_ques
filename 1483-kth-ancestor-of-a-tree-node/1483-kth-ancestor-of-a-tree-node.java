class TreeAncestor {
    int[][] parent;
    public TreeAncestor(int n, int[] par) {
        parent = new int[17][n];  // log2 (10^5) = 17

        for(int i=0;i<n;i++){
            parent[0][i]= par[i];
        }

        //cal 1 to 17th ancestor of each node
        for(int k=1;k<17;k++){
            for(int i=0;i<n;i++){
                int prevNode = parent[k-1][i];                  
                parent[k][i] = prevNode == -1 ? -1 : parent[k-1][prevNode];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=0;i<17 && node != -1;i++){
            int mask = (1 << i);
            if((k & mask) != 0){
                node = parent[i][node];
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