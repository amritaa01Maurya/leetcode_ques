class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int m = flights.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            adj.get(u).add(new int[]{v,wt});
        }

        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);

        price[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0,0});

        while(!q.isEmpty()){
            int[] arr = q.remove();

            int curr = arr[0];
            int cost = arr[1];
            int step = arr[2];

            if(step > k) break;

            for(int[] list :adj.get(curr)){
                int v = list[0];
                int wt = list[1];

                if(cost + wt < price[v] && step <= k ){
                    price[v] = cost + wt;
                    q.add(new int[]{v, price[v], step+1});
                }
            }
        }
        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
}