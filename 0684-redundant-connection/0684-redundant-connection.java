class DS{
    int[] par, rank;
    public DS(int n){
        par = new int[n+1];
        rank = new int[n+1];
        
        for(int i=1;i<=n;i++){
            par[i] = i;
        }
    }
    public int find(int a){
        if(a == par[a]){
            return a;
        }
        return par[a] = find(par[a]);
    }

    public void union(int a, int b){
        int para = find(a);
        int parb = find(b);
        if(rank[para] == rank[parb]){
            par[parb] = para;
            rank[para]++;
        }else if(rank[para] > rank[parb]){
            par[parb] = para;
        }else{
            par[para] = parb;
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DS ds = new DS(n);
        for(int[] e:edges){
            int a = e[0];
            int b = e[1];
            if(ds.find(e[0]) == ds.find(e[1])){
                return e;
            }
            ds.union(a, b);
        }
        return new int[0];
    }
}