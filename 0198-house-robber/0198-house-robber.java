class Solution {
    public int maxRob(int[] nums, int i, int[] dp) {
        if(i > nums.length - 1){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int rob = nums[i] + maxRob(nums, i + 2, dp);
        int dontrob = maxRob(nums, i + 1, dp);
        return dp[i] = Math.max(rob, dontrob);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxRob(nums, 0, dp);
    }
}