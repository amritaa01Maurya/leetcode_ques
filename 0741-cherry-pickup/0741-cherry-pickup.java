class Solution {
    public int dfs(int[][] grid, int[][][][] dp , int i, int j, int k, int l) {
        int n = grid.length;
        int m = grid[0].length;
        if(i >= n || j >= m || k >= n || l >= m || grid[i][j] == -1 || grid[k][l] == -1){
            return Integer.MIN_VALUE;
        }
        if(i == n - 1 && j == m - 1){
            return grid[i][j];
        }

        if(dp[i][j][k][l] != -1){
            return dp[i][j][k][l];
        }

        int ans = grid[i][j];
        if(i != k || j != l){
            ans += grid[k][l];
        }

        int RR = dfs(grid, dp, i, j + 1, k, l + 1);
        int DR = dfs(grid, dp, i + 1, j, k, l + 1);

        int DD = dfs(grid, dp, i + 1 , j ,k + 1, l);
        int RD = dfs(grid, dp, i, j + 1,k + 1, l);

        int maxPick = Math.max(RR, Math.max(DR, Math.max(DD, RD)));
        
        return dp[i][j][k][l] = ans + maxPick;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][][] dppp = new int[n][m][n][m];
        for(int[][][] dpp:dppp){
            for(int[][] dp:dpp){
                for(int[] d:dp){
                    Arrays.fill(d, -1);
                }
            }
        }

        return Math.max(0,dfs(grid, dppp, 0, 0, 0, 0));

    }
}