class Solution {
    public void bfs(List<List<Integer>> adj, int src, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neigh : adj.get(curr)) {
                if (dist[neigh] == -1) {
                    dist[neigh] = dist[curr] + 1;
                    q.add(neigh);
                }
            }
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                adj.get(i).add(edges[i]);
            }
        }

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        dist1[node1] = 0;

        Arrays.fill(dist2, -1);
        dist2[node2] = 0;

        // cal dist of each node from node1 and node2
        bfs(adj, node1, dist1);
        bfs(adj, node2, dist2);
        
        int minDist = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1 && minDist > Math.max(dist1[i], dist2[i])) {// we want node that can be reach from node1 and node2 both, and its dist minimized (such that max dist of node from node1 and node2 taken) 
                minDist = Math.max(dist1[i], dist2[i]);
                node = i;
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : node;
    }
}