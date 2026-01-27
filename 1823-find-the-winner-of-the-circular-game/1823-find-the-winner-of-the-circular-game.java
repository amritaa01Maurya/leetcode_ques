class Solution {
    public int solve(List<Integer> l , int i, int k){
        if(l.size()== 1){
            return l.get(0);
        }
        int nextK = (i+k-1)%l.size();
        l.remove(nextK);
        return solve(l, nextK, k);
    }
    public int findTheWinner(int n, int k) {
        List<Integer> l = new ArrayList<>();
        for(int i=1;i<=n;i++){
            l.add(i);
        }
        return solve(l, 0, k);
    }
}