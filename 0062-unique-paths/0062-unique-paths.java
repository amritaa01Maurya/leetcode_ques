class Solution {
    public int paths(int m, int n, int[][] dp) {
        if(m < 0 || n < 0){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int right = paths(m, n-1, dp);
        int down = paths(m-1, n, dp);

        return dp[m][n] = right + down;

    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return paths(m-1,n-1, dp);

    }
}