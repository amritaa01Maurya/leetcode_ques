class Solution {
    int mod = 1000000007;
    public int countHousePlacements(int n) {
        if(n == 1){
            return 4;
        }
        
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] % mod + dp[i-2] % mod;
        }
        long ans = (dp[n] * dp[n] )% mod;
        return (int) ans % mod;
    }
}