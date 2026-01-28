class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);

        for(int i=1;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst() < i - k){
                dq.pollFirst();
            }

            dp[i] = nums[i] + dp[dq.peekFirst()];

            while(!dq.isEmpty() && dp[i] >= dp[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return dp[n-1];
    }
}