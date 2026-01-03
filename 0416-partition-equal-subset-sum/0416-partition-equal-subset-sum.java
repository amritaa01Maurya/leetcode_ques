class Solution {
    public int solve(int[] nums, int i, int sum, int[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (i < 0 || sum < 0)
            return 0;

        
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        int inc = 0;
        if (nums[i] <= sum) {
            inc = solve(nums, i - 1, sum - nums[i], dp);
        }
        int exc = solve(nums, i - 1, sum, dp);

        return dp[i][sum] = inc | exc;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int[][] dp = new int[n][sum / 2 + 1];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }

        return solve(nums, n - 1, sum / 2, dp) == 1;
    }
}