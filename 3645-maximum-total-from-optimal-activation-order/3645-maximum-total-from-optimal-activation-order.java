class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n= value.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]= value[i];
            arr[i][1]= limit[i];
        }

        Arrays.sort(arr, (a, b) ->{
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });

        long score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int actEle = 0;
        for(int i=0;i<n;i++){
            if(actEle < arr[i][1]){//limit is  active element
                pq.offer(arr[i][1]);
                score += arr[i][0];
                int x = pq.size(); // curr active element
                actEle = Math.max(x, actEle);
                while(!pq.isEmpty() && pq.peek() <= x){
                    pq.poll();
                }
            }
        }
        return score;
    }
}