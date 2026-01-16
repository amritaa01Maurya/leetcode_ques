class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum =0;
        for(int num:nums){
            sum += num;
        }
        long need = Math.abs(goal - sum);
        long count = (long)Math.ceil((double)need/limit);
        return (int)count;
        
    }
}