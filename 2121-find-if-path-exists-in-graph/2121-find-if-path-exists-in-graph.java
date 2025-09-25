class Solution {
    public boolean hasPath(List<List<Integer>> adj, int src, int dest, boolean[] vis) {
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(Integer neigh: adj.get(src)){
            if(!vis[neigh]){
                if(hasPath(adj, neigh, dest, vis))
                return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        List<List<Integer>>  adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        return hasPath(adj, src, dest, vis);

    }
}