class Solution {
    public void sum(int[] candidates, int target, List<List<Integer>> ll, List<Integer> l, int i) {
        if(target == 0){
            ll.add(new ArrayList<>(l));
            return;
        }
        for(int j=i;j<candidates.length;j++){
            if(target - candidates[j] >= 0){
                l.add(candidates[j]);
                sum(candidates, target - candidates[j], ll, l, j);
                l.remove(l.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        sum(candidates, target, ll, l, 0);

        return ll;
    }
}