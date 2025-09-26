class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + ( r - l)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] == nums[l] && nums[mid] == nums[r]){
                l++;
                r--;
            }
            else if (nums[mid] >= nums[l]){
                if(target >= nums[l] && target <= nums[mid]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target >= nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
        }
        return false;
    }
}