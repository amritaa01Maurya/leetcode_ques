class Solution {
    public long maxStrength(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        Arrays.sort(nums);

        int neg = 0;
        int pos = 0;
        long posPr = 1;
        long negPr = 1;
        int maxNeg = -9;
        for(int i=0;i<n;i++){
            if(nums[i] < 0){
                neg++;
                negPr *= nums[i];
                maxNeg = Math.max(maxNeg, nums[i]);
            }else if(nums[i] > 0){
                pos++;
                posPr *= nums[i];
            }
        }
        if(neg <= 1 && pos ==0){
            return 0;
        }else if(neg % 2 != 0){
            negPr /= maxNeg;
            return negPr * posPr;
        }else{
            return negPr * posPr;
        }
    }
}