class Solution {
    int[] dist1;
    int[] dist2;
    public void dij(List<List<Integer>> adj, int src, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int neigh: adj.get(curr)){
                if(dist[curr] + 1 < dist[neigh] && dist[curr] != Integer.MAX_VALUE){
                    dist[neigh] = dist[curr] + 1;
                    q.add(neigh);
                }
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(edges[i] != -1){
                adj.get(i).add(edges[i]);
            }
        }
        dist1 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        dist1[node1] = 0;
        
        dist2 = new int[n];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist2[node2] = 0;

        dij(adj,node1, dist1);
        dij(adj,node2, dist2);

        int[] dist = new int[n];
        int mindist = Integer.MAX_VALUE;
        int minNode = -1;
        for(int i=0;i<n;i++){
            if(dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE-1){
                continue;
            }else if (mindist > Math.max(dist1[i],dist2[i])){
                mindist = Math.max(dist1[i],dist2[i]);
                minNode = i;
            }
        }
        return mindist == Integer.MAX_VALUE ? -1 : minNode;
    }
}