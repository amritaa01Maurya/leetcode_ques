class Solution {
    int[][] moves = {{1,2}, {1, -2}, {-1, 2},{-1, -2}, {2,1}, {-2, 1}, {2, -1}, {-2, -1}};
    double[][][] dp;
    public double solve(int n, int k, int row, int col) {
        if(row >= n || col >= n || row < 0 || col < 0){
            return 0.0;
        }
        if(k == 0){
            return 1.0;
        }
        if(dp[row][col][k] != -1.0){
            return dp[row][col][k];
        }
        double ans = 0.0;
        for(int[] m:moves){
            int nr = row + m[0];
            int nc = col + m[1];
            if(nr < n && nc < n){
                ans += (1.0/8)* solve(n, k-1, nr, nc);
            }
        }
        return dp[row][col][k] = ans;
    }
    public double knightProbability(int n, int k, int row, int col) {
        dp = new double[n][n][k+1];
        for(double[][] dd:dp){
            for(double[] d:dd){
                Arrays.fill(d, -1.0);
            }
        }
        return solve(n, k, row, col);
    }
}