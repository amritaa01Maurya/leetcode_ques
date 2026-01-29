class Solution {
    public int findLengthOfShortestSubarray(int[] nums) {
        int n=nums.length;
        int l =0;
        int r = n - 1;
        while(l < n - 1 && nums[l] <= nums[l + 1]){
            l++;
        }

        if(l == n - 1){
            return 0;
        }
        while(r > 0 && nums[r] >= nums[r-1]){
            r--;
        }

        int ans = Math.min(n - l - 1, r);//we remove either ele right to l or ele left to r
        int i =0;
        int j = r;
        while(i <= l && j < n){
            if(nums[i] <= nums[j]){
                ans = Math.min(ans, j - i - 1);
                i++;
            }else{
                j++;
            }
        }
        
        return ans > n ? n - 1 : ans;
    }
}