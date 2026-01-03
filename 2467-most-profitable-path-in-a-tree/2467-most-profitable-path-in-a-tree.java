class Solution {
    int ans;
    public boolean getBobTime(List<List<Integer>> adj, int[] time,int curr, int par, int currTime) {
        if(curr == 0){
            time[curr] = currTime;
            return true;
        }
        for(int neigh: adj.get(curr)){
            if(neigh == par) continue;
            if(getBobTime(adj, time, neigh, curr, currTime + 1)){
                time[curr] = currTime;
                return true;
            }
        }
        return false;
    }

    public void aliceProfit(List<List<Integer>> adj, int[] bobTime, int curr, int par,  int currTime, int[] amount, int amt) {
        int newAmt = 0;
        if(currTime < bobTime[curr]){
            newAmt = amount[curr];
        }
        else if(currTime == bobTime[curr]){
            newAmt = amount[curr] / 2;
        }
        amt += newAmt;
        boolean leaf = true;
        for(int neigh: adj.get(curr)){
            if(neigh == par) continue;
            
            leaf = false;
            aliceProfit(adj, bobTime, neigh, curr, currTime + 1, amount, amt);
        }
        if(leaf){
            ans = Math.max(ans, amt);
        }

    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ans  = Integer.MIN_VALUE;

        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);

        getBobTime(adj, bobTime, bob, -1, 0);

        aliceProfit(adj, bobTime, 0, -1, 0, amount, 0);
        

        return ans;
    }
}