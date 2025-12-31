class DS{
    int[] par, rank;
    public DS(int n){
        par = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n;i++){
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DS ds = new DS(accounts.size());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<accounts.size();i++){
            List<String> list = accounts.get(i);
            for(int j=1;j<list.size();j++){
                String email = list.get(j);
                if(!map.containsKey(email)){
                    map.put(email,i);
                }else{
                    int prevIdx = map.get(email);
                    int par1 = ds.find(prevIdx);
                    int par2 = ds.find(i);
                    if(par1 != par2){
                        ds.union(par1 ,par2);
                    }
                }
            }
        }
        HashMap<Integer, TreeSet<String>> rootToEle = new HashMap<>();
        for(Map.Entry<String, Integer> e:map.entrySet()){
            String email = e.getKey();
            int idx = e.getValue();
            int root = ds.find(idx);
            rootToEle.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, TreeSet<String>> e:rootToEle.entrySet()){
            List<String> li = new ArrayList<>();
            int idx = e.getKey();
            li.add(accounts.get(idx).get(0));
            li.addAll(rootToEle.get(idx));
            res.add(li);
        }
        return res;
    }
}