class Solution {
    public void dfs(List<List<Integer>> adj, int curr, boolean[] vis) {
        vis[curr] = true;
        for(int neigh: adj.get(curr)){
            if(!vis[neigh]){
                dfs(adj, neigh, vis);
            }
        }
        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj, i, vis);
                count++;
            }
        }
        return count;
    }
}