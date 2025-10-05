class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int minPair = 0;
        int i = 0;
        int j= nums.length - 1;
        while(i < j){
            minPair = Math.max(nums[i] + nums[j], minPair);
            i++;
            j--;
        }
        return minPair;
    }
}