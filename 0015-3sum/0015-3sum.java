class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> l = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int j = 0;
        int k = 0;
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    l.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        ans.addAll(l);
        return ans;
    }
}