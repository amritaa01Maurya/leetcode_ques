class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxlis = 1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxlis = Math.max(dp[i], maxlis);
        }

        int totlis = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxlis){
                totlis += count[i]; 
            }
        }
        return totlis;
    }
}