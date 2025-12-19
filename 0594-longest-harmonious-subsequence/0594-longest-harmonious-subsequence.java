class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l=0;
        int ans = 0;
        for(int r=0;r<n;++r){
            if(nums[r]-nums[l]==1){
                ans = Math.max(ans,r-l+1);
            }  
            while(nums[r]-nums[l]>1){
                l++;
            }
        }
        return ans;
    }
}