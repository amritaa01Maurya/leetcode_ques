class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Set<Integer> vis = new HashSet<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        if(arr[start] == 0){
            return true;
        }
        vis.add(start);
        dq.offer(start);
        while(!dq.isEmpty()){
            int pos = dq.poll();
            if(arr[pos] == 0){
                return true;
            }
            int left = pos - arr[pos];
            if(left >= 0 && !vis.contains(left)){
                vis.add(left);
                dq.offer(left);
            }
            int right = pos + arr[pos];
            if(right < n && !vis.contains(right)){
                vis.add(right);
                dq.offer(right);
            }
        }
        return false;
    }
}