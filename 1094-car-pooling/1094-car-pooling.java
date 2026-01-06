class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] prefix = new int[1001];

        for(int i=0;i<trips.length; i++){
            int start = trips[i][1];
            int end = trips[i][2];
            prefix[start] += trips[i][0];
            prefix[end] -= trips[i][0];  
        }
        int cap = 0;
        for(int i=0;i<1001;i++){
            cap += prefix[i];
            if(cap > capacity){
                return false;
            }
        }
        return cap <= capacity;
    }
}