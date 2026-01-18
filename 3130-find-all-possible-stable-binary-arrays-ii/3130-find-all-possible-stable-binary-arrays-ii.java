class Solution {
    int mod = 1000000007;
    public int numberOfStableArrays(int ze, int on, int lim) {
        int[][][] dp = new int[ze+1][on+1][2];
        
        for(int i=0;i<=Math.min(ze, lim);i++){
            dp[i][0][0] = 1;
        }
        for(int i=0;i<=Math.min(on, lim);i++){
            dp[0][i][1] = 1;
        }

        for(int z=1;z<=ze;z++){
            for(int o=1;o<=on;o++){
                dp[z][o][0] = (dp[z-1][o][0] + dp[z-1][o][1])%mod;
                dp[z][o][1] = (dp[z][o-1][0] + dp[z][o-1][1])%mod;
                if(z > lim){
                    dp[z][o][0] = (dp[z][o][0] - dp[z-lim- 1][o][1] + mod) % mod;
                }
                if(o > lim){
                    dp[z][o][1] = (dp[z][o][1] - dp[z][o-lim- 1][0] + mod) % mod;
                }
            } 
        }
        return (dp[ze][on][0] + dp[ze][on][1])%mod;
    }
}