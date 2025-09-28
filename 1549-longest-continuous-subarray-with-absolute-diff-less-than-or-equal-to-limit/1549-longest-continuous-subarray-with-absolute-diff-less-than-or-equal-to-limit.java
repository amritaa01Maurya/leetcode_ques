class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();;
        int l = 0;
        int maxLen = 0;
        for(int r=0;r<n;r++){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            while(map.lastKey() - map.firstKey() > limit){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            if( r - l + 1 > maxLen){
                maxLen = r - l + 1;
            }  
        }
        return maxLen;
    }
}