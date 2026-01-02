class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        // Queue<int[]> q = new LinkedList<>();

        int[][] times = new int[n+1][2];
        for(int[] tm:times){
            Arrays.fill(tm, Integer.MAX_VALUE);
        }

        q.add(new int[]{1,0});

        times[1][0] = 0;

        int green = 2 * change;
        
        while(!q.isEmpty()){
            int[] a = q.remove();
            int curr = a[0];
            int tm = a[1];
            if(tm > times[curr][1]) continue;

            for(int neigh: adj.get(curr)){
                if(tm % green >= change){
                    tm += green - (tm % green); // wait time;
                }
                if(tm + time < times[neigh][0]){
                    times[neigh][1] = times[neigh][0];
                    times[neigh][0] = tm + time;
                    q.add(new int[]{neigh, times[neigh][0]});
                }else if(tm + time > times[neigh][0] && tm + time < times[neigh][1]){
                    times[neigh][1] = tm + time;
                    q.add(new int[]{neigh, times[neigh][1]});
                }
            }
        }
        return times[n][1];
    }
}