class Solution {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length;
        long count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.offer(nums[i]);
            if(!pq.isEmpty() && s.charAt(i) == '1' ){
                count += pq.poll();
            }
        }
        return count;
    }
}