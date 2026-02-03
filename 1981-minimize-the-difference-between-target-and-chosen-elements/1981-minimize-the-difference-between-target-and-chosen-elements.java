class Solution {
    public int solve(int[][] mat, int t, int r, int sum, int[][] dp) {
        int n  = mat.length;
        int m  = mat[0].length;
        if(r > n){
            return Integer.MAX_VALUE;
        }

        if(r == n){
            return Math.abs(sum - t);
        }

        if(dp[r][sum] != -1){
            return dp[r][sum];
        }

        int ans = Integer.MAX_VALUE;
        for(int c=0;c<m;c++){
            ans = Math.min(ans, solve(mat, t, r + 1, sum + mat[r][c], dp));
        }
        
        return dp[r][sum] = ans;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int n  = mat.length;
        int[][] dp = new int[n][4901];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return solve(mat, target, 0, 0, dp);
    }
}