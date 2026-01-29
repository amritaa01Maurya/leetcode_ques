class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int idx = -1;// last index of ele out of range (mink, maxk)
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        long count = 0;
        for(int i=0;i<n;i++){
            if(nums[i] < minK || nums[i] > maxK){
                min.clear();
                max.clear();
                idx = i;
                continue;
            }
            while(!min.isEmpty() && nums[min.peekLast()] >= nums[i]){
                min.pollLast();
            }
            min.addLast(i);
            while(!max.isEmpty() && nums[max.peekLast()] <= nums[i]){
                max.pollLast();
            }
            max.addLast(i);
            
            if(nums[min.peekFirst()] == minK && nums[max.peekFirst()] == maxK){

                count += Math.max(0, Math.min(min.peekFirst(), max.peekFirst()) - idx);//valid subarrays are b/w last invalid idx and min /max indices
            }
        }
        return count;
    }
}