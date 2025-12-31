class Solution {
    public boolean solve(int n, int src, int dest, List<List<Integer>> adj, boolean[] vis) {
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int neigh: adj.get(src)){
            if(!vis[neigh]){
                if(solve(n, neigh, dest, adj, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        if(src == dest){
            return true;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] ed:edges){
            int u = ed[0];
            int v = ed[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        return solve(n, src, dest, adj, vis);
    }
}