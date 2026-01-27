class Solution {
    public int minQuery(int num, int i, int[][] queries, int qi, int[][] dp) {
        int m = queries.length;
        if(num == 0){// if we found sum equals to num return the qi
            return qi;
        }
        if(qi >= m || num < 0){// if num becomes -ve or queries finishes
            return Integer.MAX_VALUE;
        }

        if(dp[num][qi] != -1){
            return dp[num][qi];
        }
        int exc = minQuery(num, i, queries, qi + 1, dp);//skip this query
        int inc = Integer.MAX_VALUE; 
        // if  num is in query range  take this query
        if(i >= queries[qi][0] && i <= queries[qi][1]){
            inc = minQuery(num - queries[qi][2], i, queries, qi + 1, dp);
        }

        return dp[num][qi] = Math.min(inc, exc);
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int ans = -1;
        for(int i=0;i<n;i++){
            int[][] dp = new int[nums[i]+1][m];
            for(int[] d:dp){
                Arrays.fill(d, -1);
            }

            ans = Math.max(ans, minQuery(nums[i], i, queries, 0, dp));
        }
        return ans >= Integer.MAX_VALUE ? -1 : ans;
    }
}