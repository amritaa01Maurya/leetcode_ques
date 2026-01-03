class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        boolean[][] dp = new boolean[n+1][sum/2 + 1];
        for(int  i=0;i<=n;i++){
            dp[i][0] = true;
        }

        for(int i =1;i<=n;i++){
            for(int s=1;s<=sum/2;s++){
                if(nums[i-1] <= s){
                    dp[i][s] = dp[i-1][s-nums[i-1]] || dp[i-1][s];
                }else{
                    dp[i][s] = dp[i-1][s];
                }
            }
        }
        return dp[n][sum/2];
    }
}