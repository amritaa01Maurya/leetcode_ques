class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;
        int mnsum = 0;
        int maxSum = Integer.MIN_VALUE;
        int mxsum = 0;
        int totSum =0;
        for(int num: nums){
            totSum += num;
            mnsum = Math.min(num, mnsum + num);
            minSum = Math.min(minSum, mnsum);

            mxsum = Math.max(num, mxsum + num);
            maxSum = Math.max(maxSum, mxsum);
        }
        if(totSum == minSum){
            return maxSum;
        }
        int cir_sum = totSum - minSum;

        return Math.max(cir_sum, maxSum);
    }
}