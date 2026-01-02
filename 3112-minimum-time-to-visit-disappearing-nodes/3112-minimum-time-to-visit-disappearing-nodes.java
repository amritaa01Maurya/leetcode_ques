class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u = e[0];
            int v = e[1];
            int t = e[2];
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u, t});
        }
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        pq.offer(new int[]{0, 0});//time, node

        time[0] = 0;
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int currTim = a[0];
            int curr=a[1];
            if(currTim >= disappear[curr] || currTim > time[curr]){
                continue;
            }
            for(int[] node: adj.get(curr)){
                int neigh = node[0];
                int tm = node[1];
                if(currTim + tm < disappear[neigh] && currTim + tm < time[neigh]){
                    time[neigh] = currTim + tm;
                    pq.offer(new int[]{time[neigh], neigh});
                }
            }
        }
        for(int i=0;i<n;i++){
            if(time[i] == Integer.MAX_VALUE){
                time[i] = -1;
            }
        }
        return time;
    }
}