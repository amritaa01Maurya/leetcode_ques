class Solution {
    public void subsetsInArray(int[] nums, List<List<Integer>> ll, List<Integer> l, int i) {
        if(i >= nums.length){
            ll.add(new ArrayList<>(l));
            return;
        }

        subsetsInArray(nums, ll, l, i + 1);
        l.add(nums[i]);
        subsetsInArray(nums, ll, l, i + 1);
        l.remove(l.size() - 1);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n =nums.length;
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        boolean[] vis = new boolean[n];
        subsetsInArray(nums, ll, l, 0);
        return ll;
    }
}