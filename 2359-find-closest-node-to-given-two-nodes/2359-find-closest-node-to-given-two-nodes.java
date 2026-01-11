class Solution {
    public void solve(List<List<Integer>> adj, int src, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int neigh : adj.get(curr)) {
                if (dist[curr] + 1 < dist[neigh] && dist[curr] != Integer.MAX_VALUE) {
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
        Arrays.fill(dist1, Integer.MAX_VALUE);

        dist1[node1] = 0;
        solve(adj, node1, dist1);

        int[] dist2 = new int[n];
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dist2[node2] = 0;
        solve(adj, node2, dist2);

        int maxdist = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE - 1
                    && maxdist > Math.max(dist1[i], dist2[i])) {
                maxdist = Math.max(dist1[i], dist2[i]);
                node = i;
            }
        }
        return maxdist == Integer.MAX_VALUE ? -1 : node;
    }
}