class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int r = n - 1;
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        long subCount = 0;
        long op = 0;
        for(int l = n - 1; l >= 0; l--){
            int count = 0;
            while(!dq.isEmpty() && nums[l] > dq.peekFirst()[0]){
                int[] a = dq.pollFirst();
                count += a[1];
                op += (long)a[1] * (long)(nums[l] - a[0]);
            }
            
            dq.offerFirst(new int[]{nums[l], count + 1});
            
            while(op > k){
                int[] a = dq.peekLast();
                op -= (long)(a[0] - nums[r]);
                a[1]--;
                if(a[1] == 0){
                    dq.pollLast();
                }
                r--;
            }
            subCount += (long)(r - l + 1);
        }
        return subCount;
    }
}