class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxlen = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> odd = new HashSet<>();
            Set<Integer> even = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 != 0) {
                    odd.add(nums[j]);
                } else {
                    even.add(nums[j]);
                }

                if (odd.size() == even.size() ) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
        }
        return maxlen;
    }
}