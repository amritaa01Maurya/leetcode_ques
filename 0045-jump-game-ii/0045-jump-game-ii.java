class Solution { 
    public int jump(int[] nums) { 
        int minJump = 0;
        int l=0;
        int r=0;
        while(r < nums.length - 1){
            int maxLen = 0;
            for(int i=l;i<=r;i++){
                maxLen = Math.max(maxLen, nums[i] + i);
            }
            l = r + 1;
            r = maxLen;
            minJump++;
        }
        return minJump;
    }
}