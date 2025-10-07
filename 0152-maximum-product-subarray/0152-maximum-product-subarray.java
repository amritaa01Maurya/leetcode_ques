class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefixProduct = 1;
        int suffixProduct = 1;

        int maxProduct = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            prefixProduct *= nums[i];
            suffixProduct *= nums[n-i-1];

            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
            if(prefixProduct == 0){
                prefixProduct = 1;
            }
            if(suffixProduct == 0){
                suffixProduct = 1;
            }
        }
        return maxProduct;
    }
}