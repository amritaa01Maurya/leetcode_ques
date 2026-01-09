class Solution {
    public int binarySearch(int[] nums, int x){
        int l =0;
        int r = nums.length - 1;
        int ans = -1;
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] <= x){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans + 1;
    }
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean[] ans = new boolean[n];
        boolean[][] dp = new boolean[n+1][k+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                boolean inc = false;
                if(nums[i-1] <= j){
                    inc = dp[i-1][j-nums[i-1]];
                }
                boolean exc = dp[i-1][j];

                dp[i][j] = inc || exc;
            }
        }
        for(int x=1;x<=n;x++){
            int idx = binarySearch(nums, x);
            for(int i=0;i<=n-idx;i++){
                int remSum = k - i * x;
                if(remSum >= 0 && dp[idx][remSum]){
                    ans[x - 1] = true;
                    break;
                }
            }
        }
        return ans;
    }
}