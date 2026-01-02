class Solution {
    public boolean solve(List<List<Integer>> adj, int[] col, int curr) {
        for(int neigh:adj.get(curr)){
            if(col[neigh] == -1){
                col[neigh] = col[curr] == 0? 1:0;
                if(!solve(adj, col, neigh)){
                    return false;
                }
            }else if(col[neigh] == col[curr]){
                return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] dis:dislikes){
            int u = dis[0];
            int v = dis[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] col = new int[n+1];
        Arrays.fill(col, -1);
        for(int i=1;i<=n;i++){
            if(col[i] == -1){
                col[i] = 0;
                if(!solve(adj, col, i)){
                    return false;
                }
            }
        }
        return true;
    }
}