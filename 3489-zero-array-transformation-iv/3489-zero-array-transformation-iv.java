class Solution {
    public int solve(int[][] queries, int qi, int tidx, int num, int[][] dp) {
        int n =queries.length;
        if(num == 0){
            return qi;
        }
        if(qi >= n || num < 0){
            return n+1;
        }

        if(dp[qi][num] != -1){
            return dp[qi][num];
        }

        int inc = n+1;
        if(queries[qi][0] <= tidx && queries[qi][1] >= tidx ){
            inc = solve(queries, qi + 1, tidx, num - queries[qi][2], dp);
        }
        int exc = solve(queries, qi + 1, tidx, num, dp);

        return dp[qi][num] = Math.min(inc, exc);
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n =queries.length;
        int m = nums.length;
        int minQ = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int[][] dp = new int[n+1][nums[i]+1];
            for(int[] d:dp){
                Arrays.fill(d, -1);
            }
            minQ = Math.max(minQ, solve(queries, 0, i, nums[i], dp));
        }
        return minQ > n ? -1: minQ;
    }
}