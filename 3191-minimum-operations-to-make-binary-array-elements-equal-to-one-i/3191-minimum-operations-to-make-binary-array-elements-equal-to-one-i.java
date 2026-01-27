class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int flip = 0;
        for(int i=0;i < n - 2;i++){
            if(nums[i] == 0){// if ele is 0 flip it and next 2 consecutive ele;
                nums[i] = 1;
                nums[i+1] = nums[i+1] == 0 ? 1 : 0;
                nums[i+2] = nums[i+2] == 0 ? 1 : 0;
                flip++;
            }
        }

        // check if all ele are one on not
        for(int num:nums){
            if(num != 1){
                return -1;
            }
        }

        return flip;
    }
}