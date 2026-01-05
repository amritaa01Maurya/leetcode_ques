class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length; 
        int[][] dp = new int[n+1][m+1];
        for(int[] d:dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[n][m-1] = 1;
        dp[n-1][m] = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int right = dp[i][j+1];
                int down = dp[i+1][j];
                dp[i][j] = Math.max(1, Math.min(right, down)- dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}