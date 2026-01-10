class Solution {
    public int findDryDay(List<Integer> dryDay, int t) {
        int ans = dryDay.size();
        int l = 0;
        int r = dryDay.size() - 1;
        while(l <= r){
            int mid = (l + r)/2;
            if(dryDay.get(mid) > t){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public int[] avoidFlood(int[] rains) {
        int n= rains.length;
        int[] ans = new int[n];

        Arrays.fill(ans, 100000000);
        boolean flood = false;
        Map<Integer, Integer> rainDay = new HashMap<>();
        List<Integer> dryDay = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(rains[i] == 0){
                dryDay.add(i);
            }else{
                if(rainDay.containsKey(rains[i])){
                    int idx = findDryDay(dryDay, rainDay.get(rains[i]));
                    if(idx == dryDay.size()){
                        return new int[0];
                    }
                    ans[dryDay.get(idx)] = rains[i];
                    dryDay.remove(idx);
                }
                rainDay.put(rains[i], i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}