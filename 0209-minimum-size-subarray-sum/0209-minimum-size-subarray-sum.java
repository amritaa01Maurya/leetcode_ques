class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l =0;
        int sum = 0;
        int minLen = n + 1;
        for(int r=0;r<n;r++){
            sum += nums[r];
            while( sum >= target){
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return minLen == n + 1 ? 0 : minLen;
    }
}