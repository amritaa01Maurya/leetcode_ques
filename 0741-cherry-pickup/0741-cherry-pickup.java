class Solution {
    public int dfs(int[][] grid, Integer[][][] dp, int i, int j, int k) {
        int n = grid.length;
        int l = i + j - k;

        if (i >= n || j >= n || k >= n || l >= n || grid[i][j] == -1 || grid[k][l] == -1) {
            return Integer.MIN_VALUE;
        }
        if (i == n - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        int ans = grid[i][j];
        if (i != k || j != l) {
            ans += grid[k][l];
        }

        int RR = dfs(grid, dp, i, j + 1, k);
        int DR = dfs(grid, dp, i + 1, j, k);

        int DD = dfs(grid, dp, i + 1, j, k + 1);
        int RD = dfs(grid, dp, i, j + 1, k + 1);

        int maxPick = Math.max(RR, Math.max(DR, Math.max(DD, RD)));
        
        return dp[i][j][k] = ans + maxPick;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        Integer[][][] dppp = new Integer[n][n][n];

        return Math.max(0, dfs(grid, dppp, 0, 0, 0));

    }
}