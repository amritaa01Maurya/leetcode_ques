class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        if(arr[start] == 0){
            return true;
        }
        vis[start] = true;
        dq.offer(start);
        while(!dq.isEmpty()){
            int pos = dq.poll();
            if(arr[pos] == 0){
                return true;
            }
            int left = pos - arr[pos];
            if(left >= 0 && !vis[left]){
                vis[left] = true;
                dq.offer(left);
            }
            int right = pos + arr[pos];
            if(right < n && !vis[right]){
                vis[right] = true;
                dq.offer(right);
            }
        }
        return false;
    }
}