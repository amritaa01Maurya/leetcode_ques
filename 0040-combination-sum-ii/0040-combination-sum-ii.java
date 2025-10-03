class Solution {
    public void sum(int[] candidates, int target, List<List<Integer>> ll, List<Integer> l, int idx) {
        if(target == 0){
            ll.add(new ArrayList<>(l));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i > idx && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target - candidates[i] >= 0){
                l.add(candidates[i]);
                sum(candidates, target - candidates[i], ll, l, i+1);
                l.remove(l.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        sum(candidates, target, ll, l, 0);

        return ll;
    }
}