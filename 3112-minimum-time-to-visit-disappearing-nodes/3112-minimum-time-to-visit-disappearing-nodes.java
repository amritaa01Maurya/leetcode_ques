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

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        pq.offer(new int[]{0, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int curr = a[0];
            int currtime = a[1];
            if(currtime > dist[curr] || currtime >= disappear[curr]){
                continue;
            }
            for(int[] arr: adj.get(curr)){
                int neigh = arr[0];
                int neightime = arr[1];
                if(currtime + neightime < disappear[neigh] && currtime + neightime < dist[neigh]){
                    dist[neigh] = currtime + neightime;
                    pq.offer(new int[]{neigh, dist[neigh]});
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }
}