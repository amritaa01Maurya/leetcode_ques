class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int idx = -1;// last index of ele out of range (mink, maxk)
        int min = -1;
        int max = -1;

        long count = 0;
        for(int i=0;i<n;i++){
            if(nums[i] < minK || nums[i] > maxK){
                idx = i;
            }
            if(nums[i] == minK ){
                min = i;
            }
            if(nums[i] == maxK){
                max = i;
            }
            
            count += Math.max(0, Math.min(min, max) - idx);//valid subarrays are b/w last invalid idx and min /max indices
        }
        return count;
    }
}