class Solution {
    public long perfectPairs(int[] nums) {
        int n =nums.length;
        long pair = 0;
        for(int i=0;i<n;i++){
            if(nums[i] < 0){
                nums[i] *= -1;
            }
        }
        Arrays.sort(nums);
        int i =0;
        int j = 1;
        while(i < n){
            while(j < n && nums[j] <= 2 * nums[i]){
                j++;
            }
            pair += (j - i - 1);
            i++;
        }
        return pair;
    }
}