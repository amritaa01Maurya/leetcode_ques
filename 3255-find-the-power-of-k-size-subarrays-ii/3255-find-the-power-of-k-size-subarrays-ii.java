class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        int n = nums.length;
        int[] res = new int[n-k+1];
        Arrays.fill(res, -1);
        int len = 1;
        for(int r=1;r<n;r++){
            if(nums[r-1] + 1 == nums[r]){
                len++;
            }else{
                len = 1;
            }
            if(len >= k){
                res[r - k + 1] = nums[r];
            }
        }
        return res;
    }
}