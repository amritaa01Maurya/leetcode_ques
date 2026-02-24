class Solution {
    class Pair {
        int node;
        long time;

        Pair(int nd, long tm) {
            this.node = nd;
            this.time = tm;
        }

    }

    int mod = 1000000007;

    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int t = r[2];
            adj.get(u).add(new Pair(v, (long) t));
            adj.get(v).add(new Pair(u, (long) t));
        }
        long[] dist = new long[n];
        long[] ways = new long[n];
        ways[0] = 1;
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Long.compare(p1.time, p2.time);
            }
        });
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair arr = pq.poll();
            int curr = arr.node;
            long tm = arr.time;
            if (tm > dist[curr])
                continue;
            for (Pair a : adj.get(curr)) {
                int neigh = a.node;
                long ndtm = a.time;
                if (ndtm + tm < dist[neigh]) {
                    dist[neigh] = ndtm + tm;
                    ways[neigh] = ways[curr] % mod;
                    pq.offer(new Pair(neigh, dist[neigh]));
                } else if (ndtm + tm == dist[neigh]) {
                    ways[neigh] = (ways[neigh] + ways[curr]) % mod;
                }
            }
        }
        return (int) ways[n - 1] % mod;
    }
}