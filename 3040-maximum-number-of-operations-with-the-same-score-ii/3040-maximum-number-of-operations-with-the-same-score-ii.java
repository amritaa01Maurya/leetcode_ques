class Solution {
    public int solve(int[] arr, int i, int j, int score, int type, int[][][] dp){
        int n = arr.length;
        if(i >= j){
            return 0;
        }
        if(dp[i][j][type] != -1){
            return dp[i][j][type];
        }
        int t1=0;
        int t2=0;
        int t3=0;
        if(i + 1 < n && arr[i] + arr[i+1] == score){
            t1 =  1 + solve(arr, i + 2, j, score, 0,dp);
        }
        if(j - 1 >= 0 && arr[j] + arr[j-1] == score){
            t2 = 1 + solve(arr, i, j-2, score, 1, dp);
        }
        if(i >= 0 && j < n && arr[i] + arr[j] == score){
            t3 = 1 + solve(arr, i+1, j-1, score,2, dp);
        }

        return dp[i][j][type] = Math.max(Math.max(t1, t2), t3);

    }
    public int maxOperations(int[] nums) {
        int n = nums.length;

        int[][][] dp = new int[n+1][n+1][3];
        for(int[][] dpp:dp){
            for(int[] dppp:dpp){
                Arrays.fill(dppp, -1);
            }
        }
        int i=0;
        int j = n -1;
        dp[i][j][0] = 0;
        if(i + 1 < n){
            dp[i][j][0] = 1 + solve(nums, i + 2, j, nums[i] + nums[i+1], 0, dp);
        }
        dp[i][j][1] = 0;
        if(j - 1 >= 0){
            dp[i][j][1] = 1 + solve(nums, i, j-2,nums[j] + nums[j-1], 1, dp);
        }
        dp[i][j][2] = 0;
        if(i < j){
            dp[i][j][2] = 1 + solve(nums, i+1, j-1, nums[i] + nums[j], 2, dp);
        }

        return Math.max(Math.max(dp[i][j][0], dp[i][j][1]), dp[i][j][2]);
    }
}