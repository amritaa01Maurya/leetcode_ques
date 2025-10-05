class Solution {
    public long minCosts(int[] nums, int[] cost, long mid) {
        int n = nums.length;
        long c = 0;
        for(int i=0;i<n;i++){
            c += cost[i] * (Math.abs(mid - nums[i]));
        }
        return c;
    }
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long l = nums[0];
        long r=nums[0];
        for(int i=1;i<n;i++){
            l = Math.min(nums[i], l);
            r = Math.max(nums[i], r);
        }
        long minCost = 0;
        while(l < r){
            long mid1 = l + ( r - l)/2;
            long mid2 = mid1 + 1;
            if(minCosts(nums, cost, mid1) < minCosts(nums, cost, mid2)){
                r = mid1;
            }else{
                l = mid1 + 1;
            }
        }
        minCost = minCosts(nums, cost, l);
        return minCost;
    }
}