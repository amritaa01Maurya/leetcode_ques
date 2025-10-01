class Solution {
    public void permute(int[] nums,List<List<Integer>> ll, List<Integer> l, boolean [] vis) {
        int n = nums.length;
        if( l.size() == n){
            ll.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1] || vis[i]) continue;
            l.add(nums[i]);
            vis[i] = true;
            permute(nums, ll, l, vis);
            l.remove(l.size() - 1);
            vis[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[n];
        permute(nums, ll, l,vis);
        return ll;
    }
}