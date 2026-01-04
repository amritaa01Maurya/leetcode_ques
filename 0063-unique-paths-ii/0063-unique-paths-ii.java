class Solution {
    public int solve(int[][] grid, int[][] dp, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(i >= n || j >= m || grid[i][j] == 1){
            return 0;
        }
        if(i == n - 1 && j == m - 1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = solve(grid, dp , i, j + 1);
        int down = solve(grid, dp , i + 1, j);

        return dp[i][j] = right + down;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }

        int ways = solve(grid, dp, 0, 0);

        return ways;
    }
}