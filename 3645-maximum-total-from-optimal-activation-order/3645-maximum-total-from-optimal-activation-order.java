class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n= value.length;
        
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(limit[i], k -> new PriorityQueue<>()).add(value[i]);
            if(map.get(limit[i]).size() > limit[i]){
                map.get(limit[i]).poll();
            }
        }

        long score = 0;
        for(int key:map.keySet()){
            PriorityQueue<Integer> pq = map.get(key);
            while(!pq.isEmpty()){
                score += pq.poll();
            }
        }
        return score;
    }
}