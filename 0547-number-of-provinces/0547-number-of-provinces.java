class Solution {
    public void dfs(int[][] isConnected, int curr, boolean[] vis) {
        vis[curr] = true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[curr][j] == 1 && !vis[j]){
                dfs(isConnected, j, vis);
            }
        }
        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected, i, vis);
                count++;
            }
        }
        return count;
    }
}