class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int firstPos = -1;
        int lastPos = -1;
        while(l<=r){
            int mid = l + (r - l)/2;
            if(nums[mid] >= target){
                if(nums[mid] == target){
                    firstPos = mid;
                }
                r  = mid - 1;
            }else{
                l = mid+1;
            }
        }
        l=0;
        r =nums.length-1;
        while(l<=r){
            int mid = l + (r - l)/2;
            if(nums[mid] <= target){
                if(nums[mid] == target){
                    lastPos = mid;
                }
                l  = mid + 1;
            }else{
                r = mid-1;
            }
        }
        return new int[] {firstPos, lastPos};
    }
}