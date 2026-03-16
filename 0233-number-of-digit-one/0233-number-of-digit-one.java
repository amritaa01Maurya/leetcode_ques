class Solution {
    public int solve(String s, int idx, int tight, int cnt, int[][][] dp) {
        if(idx == s.length()){
            return cnt;
        }
        if(dp[idx][tight][cnt] != -1){
            return dp[idx][tight][cnt];
        }

        int limit = (tight == 1)? s.charAt(idx) - '0': 9;
        int ans = 0;
        for(int i=0; i<=limit; i++){
            int newCnt = cnt + (i == 1 ? 1 : 0 );
            int newtight = (tight == 1 && i == s.charAt(idx) - '0') ? 1 : 0; 
            ans += solve(s, idx + 1, newtight, newCnt, dp);
        }
        return dp[idx][tight][cnt] = ans;
    }
    public int countDigitOne(int n) {
        String s = Integer.toString(n);
        int m = s.length();
        int[][][] dp = new int[11][2][11];// idx, tight, count
        for(int[][] d:dp){
            for(int[] dd:d){
                Arrays.fill(dd, -1);
            }
        }
        return solve(s, 0, 1, 0, dp);
    }
}