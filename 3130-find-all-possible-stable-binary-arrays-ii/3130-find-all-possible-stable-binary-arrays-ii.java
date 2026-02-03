class Solution {
    int mod = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[zero+1][one+1][2];
        
        for(int i=0;i<= Math.min(zero, limit);i++){// up to limit sub array is valid containing only zero
            dp[i][0][0] = 1;

        }
        for(int i=0;i<= Math.min(one, limit);i++){// up to limit sub array is valid containing only one
            dp[0][i][1] = 1;
        }
        for(int z=1;z<=zero;z++){
            for(int o=1;o<=one;o++){
                // if count of zero is within limit than we can add zero to subarray ending with 0 or 1
                dp[z][o][0] = (dp[z-1][o][1] + dp[z - 1][o][0])%mod;

                if(z > limit){// if count of zero exceed the limit we must substract subarrays
                    dp[z][o][0] = (dp[z][o][0] - dp[z - limit - 1][o][1] + mod) % mod;
                }

                dp[z][o][1] = (dp[z][o - 1][1] + dp[z][o - 1][0])%mod;

                if(o > limit){
                    dp[z][o][1] = (dp[z][o][1] - dp[z][o - limit - 1][0] + mod) % mod;
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }
}