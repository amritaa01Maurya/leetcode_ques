class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int k = m - 1;
        int j = n - 1;
        while(j >= 0 && k >= 0){
            if(nums2[j] > nums1[k]){
                nums1[i] = nums2[j];
                j--;
                i--;
            }else{
                nums1[i] = nums1[k];
                i--;
                k--;
            }
        }
        while(j >= 0){
            nums1[i] = nums2[j];
            i--;
            j--;
        }
    }
}