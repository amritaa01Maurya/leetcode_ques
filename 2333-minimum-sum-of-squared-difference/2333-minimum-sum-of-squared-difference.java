class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        Map<Long, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            long diff = Math.abs(nums1[i] - nums2[i]);
            map.put(diff, map.getOrDefault(diff, 0)+1);
        }

        int k = k1 + k2;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(long key:map.keySet()){
            pq.offer(key);
        }
        
        while(!pq.isEmpty() && k > 0){
            long ele = pq.poll();
            int count = map.get(ele);
            map.remove(ele);
            if(ele >= 1){
                if(count < k){
                    if(map.containsKey(ele - 1)){
                        map.put(ele - 1, map.get(ele - 1) + count);
                    }else{
                        map.put(ele - 1, count);
                        pq.offer(ele - 1);
                    }
                    k -= count;
                }else{
                    if(map.containsKey(ele - 1)){
                        map.put(ele - 1, map.get(ele - 1) + k);
                    }else{
                        map.put(ele - 1, k);
                        pq.offer(ele - 1);
                    }
                    map.put(ele, count - k);
                    pq.offer(ele);
                    k = 0;
                }

            }
        }
        long ans = 0;
        for(long key:map.keySet()){
            int freq = map.get(key);

            ans += (key * key) * freq;
        }

        return ans;
    }
}