class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return true;
        }
        int pos = nums[0];
        for(int i=1;i<n;i++){
            if(i > pos){
                return false;
            }
            pos = Math.max(pos, i + nums[i]);
            if(pos >= n - 1){
                return true;
            }
        }
        return pos >= n - 1 ? true : false;
    }
}