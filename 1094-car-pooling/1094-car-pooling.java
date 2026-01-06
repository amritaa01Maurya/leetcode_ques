class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>(){ 
            @Override 
            public int compare(int[] p1, int[] p2){ 
                if(p1[1] == p2[1]){ 
                    return Integer.compare(p1[2], p2[2]); 
                } 
                return Integer.compare(p1[1], p2[1]); 
            } 
        });

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