class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] prefix = new int[1001];

        for(int i=0;i<trips.length; i++){
            int start = trips[i][1];
            int end = trips[i][2];
            for(int j=start;j<end;j++){
                prefix[j] += trips[i][0];
                if(prefix[j] > capacity){
                    return false;
                }
            }  
        }
        return true;
    }
}