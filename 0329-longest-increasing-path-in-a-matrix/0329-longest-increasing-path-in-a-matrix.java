class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0,1},{0, -1}};
    int n;
    int m;
    public boolean isSafe(int r, int c) {
        if(r < 0 || c < 0 || r >= n || c >= m){
            return false;
        }
        return true;
    }
    public int path(int[][] matrix, int r, int c, int[][] dp) {
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        int count = 0;
        for(int[] d: dir){
            int i = r + d[0];
            int j = c + d[1];
            if(isSafe(i,j) && matrix[i][j] < matrix[r][c]){
                count =  Math.max(count, 1 + path(matrix, i, j, dp));
            }
        }
        return dp[r][c] = count;
    }
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                maxLen = Math.max(maxLen,  1 + path(matrix, i, j, dp));
            }
        }
        return maxLen;
    }
}