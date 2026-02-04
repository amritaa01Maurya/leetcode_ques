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

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);// sort on the basis of time -> earliest time first

        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[0] = 0;

        pq.offer(new int[]{0, 0});// node, time

        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int curr = a[0];
            int currtime = a[1];
            if(currtime > time[curr] || currtime >= disappear[curr]){// if the time to reach is greater than its disappear time we cannot go from this node or time to reach at this node greater than time[curr] => prev store min time
                continue;
            }

            for(int[] arr: adj.get(curr)){
                int neigh = arr[0];
                int tm = arr[1];
                if(currtime + tm < disappear[neigh] && currtime + tm < time[neigh]){
                    time[neigh] = currtime + tm;
                    pq.offer(new int[]{neigh, time[neigh]});
                }
            }
        }

        for(int i=0;i<n;i++){
            if(time[i] == Integer.MAX_VALUE){// if we did not reach at the particular node
                time[i] = -1;
            }
        }
        return time;
    }
}