class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        while(startFuel < target){
            while(i < stations.length && startFuel >= stations[i][0]){
                pq.offer(stations[i][1]);
                i++;
            }
            if(pq.isEmpty()){
                return -1;
            }
            startFuel += pq.poll();
            count++;

        }
        if(startFuel >= target){
            return count;
        }
        return -1;
    }
}