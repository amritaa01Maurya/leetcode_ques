class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                flag = true;
            }
            if(nums[i] < 1 || nums[i] > n){
                nums[i]  = 1;
            }
        }
        if(!flag){
            return 1;
        }
        for(int i=0;i<n;i++){
            int pos = Math.abs(nums[i]) - 1;
            if(nums[pos] > 0){
                nums[pos] = nums[pos] * (-1);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}