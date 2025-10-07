class Solution {
    int mod = 1000000007;
    int[][] dir = {{-1, 0}, {1, 0}, {0,1},{0, -1}};
    int n;
    int m;
    public boolean isSafe(int r, int c) {
        if(r < 0 || c < 0 || r >= n || c >= m){
            return false;
        }
        return true;
    }
    public int path(int[][] grid, int r, int c, int[][] dp) {
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        int count = 1;
        for(int[] d: dir){
            int i = r + d[0];
            int j = c + d[1];
            if(isSafe(i, j) && grid[i][j] < grid[r][c]){
                count =  (count + path(grid, i, j, dp)) % mod;
            }
        }
        return dp[r][c] = count;
    }
    
    public int countPaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int tot = 0;
        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                tot = (tot + path(grid, i, j, dp)) % mod;
            }
        }
        return tot;
    }
}