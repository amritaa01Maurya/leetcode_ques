class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long[] dp = new long[n];// valis subarray ending at idx i
        Arrays.fill(dp, 1);

        long count = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                if(nums[st.peek()] == nums[i]){
                    dp[i] += dp[st.peek()];// we found prev ele with max boundary ele, include it in current idx
                }
                st.pop();
            }

            count += dp[i];// valid subarray ending at i idx
            st.push(i);
        }
        return count;
    }
}