class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int len = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int or = 0;
            for(int j=i;j<n;j++){
                or |= nums[j];
                if(or >= k){
                    len = Math.min(len, j+1-i);
                }
            }
        }
        return len== Integer.MAX_VALUE? -1: len;
    }
}