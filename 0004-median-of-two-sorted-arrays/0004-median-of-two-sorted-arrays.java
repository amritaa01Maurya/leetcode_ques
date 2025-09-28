class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int l = 0;
        int r = m;
        while (l <= r) {
            int mid_x = l + (r - l) / 2;
            int mid_y = (m + n + 1) / 2 - mid_x;

            int x1 = (mid_x == 0) ? Integer.MIN_VALUE : nums1[mid_x - 1];
            int x2 = (mid_y == 0) ? Integer.MIN_VALUE : nums2[mid_y - 1];
            int x3 = (mid_x == m) ? Integer.MAX_VALUE : nums1[mid_x];
            int x4 = (mid_y == n) ? Integer.MAX_VALUE : nums2[mid_y];

            if (x1 <= x4 && x2 <= x3) {
                if ((m + n) % 2 == 1) {
                    return Math.max(x1, x2);
                } else {
                    return (Math.max(x1, x2) + Math.min(x3, x4)) / 2.0;
                }
            }
            if (x1 > x4) {
                r = mid_x - 1;
            } else {
                l = mid_x + 1;
            }
        }
        return -1;
    }
}