class Solution {
    public void combination(int n, int k, List<List<Integer>> ll, List<Integer> l, int start) {
        if(l.size() == k){
            ll.add(new ArrayList<>(l));
            return;
        }
        for(int i=start;i<=n;i++){
            l.add(i);
            combination(n, k, ll, l, i + 1);
            l.remove(l.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        combination(n, k, ll, l, 1);
        
        return ll;
    }
}