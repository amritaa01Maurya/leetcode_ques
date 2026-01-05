class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dist = new int[n][(1 << n)];
        for(int[] d:dist){
            Arrays.fill(d, -1);
        }
        for(int i=0;i<n;i++){
            q.add(new int[]{i, 1 << i});
            dist[i][1 << i] = 0;
        }

        while(!q.isEmpty()){
            int[] a = q.remove();
            int curr = a[0];
            int mask = a[1];
            
            if(mask == (1 << n) - 1){
                return dist[curr][mask];
            }
            for(int neigh:graph[curr]){
                int newmask = mask | (1 << neigh);

                if(dist[neigh][newmask] == -1){
                    dist[neigh][newmask] = dist[curr][mask] + 1;
                    q.add(new int[]{neigh, newmask});
                }
            }
        }
        return -1;
    }
}