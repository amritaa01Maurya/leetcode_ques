class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones){
            pq.offer(s);
        }
        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            if(y != x){
                pq.offer(Math.abs(x-y));
            }
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}