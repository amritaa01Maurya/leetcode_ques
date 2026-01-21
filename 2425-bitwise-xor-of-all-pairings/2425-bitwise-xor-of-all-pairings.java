class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n % 2 == 0 && m % 2 == 0){
            return 0;
        }
        int xor = 0;
        if(n % 2 == 1){// if 1st arr of odd length than num2 ele contribute 1-1 time to xor
            for(int num:nums2){
                xor ^= num;
            }
        }
        if(m % 2 == 1){// if 2nd arr of odd length than num1 ele contribute 1-1 time to xor
            for(int num:nums1){
                xor ^= num;
            }
        }
        return xor;
    }
}