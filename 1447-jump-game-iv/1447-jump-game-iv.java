class Solution {
    public int minJumps(int[] arr) {
       int n = arr.length;
       boolean[] vis = new boolean[n];
       Map<Integer, List<Integer>> map = new HashMap<>();
       for(int i=0;i<n;i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
       }
       Queue<Integer> q = new LinkedList<>(); 
       q.add(0);
       vis[0] = true;
       int step = 0;
       while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                int curr = q.poll();
                if(curr == n - 1){
                    return step;
                }
                int l = curr - 1;
                if(l >= 0 && !vis[l]){
                    q.add(l);
                    vis[l] = true;
                }
                int r = curr + 1;
                if(r < n && !vis[r]){
                    q.add(r);
                    vis[r] = true;
                }
                if(!map.containsKey(arr[curr])) continue;
                for(int idx: map.get(arr[curr])){
                    if(!vis[idx]) q.add(idx);
                }
                map.remove(arr[curr]);
            }
            step++;
       }
       return -1;
    }
}