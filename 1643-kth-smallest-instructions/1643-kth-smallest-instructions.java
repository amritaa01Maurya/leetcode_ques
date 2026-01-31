class Solution {
    public void solve(int i, int j, int k, int n, int m, int[][] dp, StringBuilder sb) { 
        if(i == n){ // if we are at last row 
            // we can only move to right
            while(j < m){
                sb.append("H");
                j++;
            }
            return;
        }

        if(j == m){ // if we are at last col
            // we can only move down
            while(i < n){
                sb.append("V");
                i++;
            }
            return;
        }

        // if we pick H then we are at i, j+1
        int rem_i = n - i;
        int rem_j = m - (j + 1);

        if(dp[rem_i][rem_j] >= k){//check how many path remains, if H choosen => 
            sb.append("H");
            solve(i, j + 1, k,n, m, dp, sb);
        }else{
            // if k greater than remain path after choosing H than we choose V
            sb.append("V");
            solve(i+1, j, k - dp[rem_i][rem_j] ,n, m, dp, sb);
        }
    }

    public String kthSmallestPath(int[] dest, int k) {
        int n = dest[0];
        int m = dest[1];
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        solve(0, 0, k, n, m, dp, sb);
        return sb.toString();
    }
}