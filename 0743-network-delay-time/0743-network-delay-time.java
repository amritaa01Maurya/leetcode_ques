class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int m = times.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];
            adj.get(u).add(new int[]{v, t});
        }
        int[] time = new int[n+1];
        boolean[] vis = new boolean[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k, 0});
        while(!q.isEmpty()){
            int[] arr = q.remove();

            int curr = arr[0];
            int currTime = arr[1];
            for(int[] list: adj.get(curr)){
                int v = list[0];
                int tv = list[1];
                if(currTime + tv < time[v]){
                    time[v] = currTime + tv;
                    q.add(new int[]{v, time[v]});
                }
            }
        }
        int min = Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            if(time[i] == Integer.MAX_VALUE){
                return -1;
            }
            min = Math.max(time[i], min);
        }
        return min;
    }
}