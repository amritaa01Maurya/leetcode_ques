class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> (){
            @Override
            public int compare(int[] a, int[] b){
                return b[0] - a[0];
            }
        });
        int[] ans = new int[n-k+1];
        int idx = 0;
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums[i], i});
        }
        ans[idx++] = pq.peek()[0];
        for(int i=k;i<n;i++){
            pq.add(new int[]{nums[i], i});
            while(!pq.isEmpty() && pq.peek()[1] <= i - k){
                pq.remove();
            }
            ans[idx++] = pq.peek()[0];
        }
        return ans;
    }
}