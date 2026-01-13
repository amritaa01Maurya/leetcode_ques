class Solution {
    boolean[] prime = new boolean[10000];
    public int minOperations(int n, int m) {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i < 10000; i++) {
            if (prime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    prime[j] = false;
                }
            }
        }

        if(prime[n] || prime[m]){
            return -1;
        }

        if(n == m){
            return n;
        }

        int[] cost = new int[10000];
        Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{n, n}); // starting node, intial cost

        cost[n] = n;

        while(!pq.isEmpty()){
            int[] a = pq.poll();
            int curr = a[0];
            int dt = a[1];

            if(curr == m){
                return dt;
            }
            char[] arr = String.valueOf(a[0]).toCharArray();

            for(int i=0;i<arr.length;i++){
                if(arr[i] != '9'){
                    arr[i] = (char)(arr[i] + 1);
                    int val = Integer.parseInt(new String(arr));
                    if(!prime[val] && dt + val < cost[val]){
                        cost[val] = dt + val;
                        pq.offer(new int[]{val, cost[val]});
                    }
                    arr[i] = (char)(arr[i] - 1);
                }
                if(arr[i] != '0'){
                    arr[i] = (char)(arr[i] - 1);
                    int val = Integer.parseInt(new String(arr));
                    if(arr[0] != 0 && !prime[val] && dt + val < cost[val]){ // check if there is leading zeros ; arr[0] == 0;
                        cost[val] = dt + val;
                        pq.offer(new int[]{val, cost[val]});
                    }
                    arr[i] = (char)(arr[i] + 1);
                }
            }
        }
        return -1;
    }
}