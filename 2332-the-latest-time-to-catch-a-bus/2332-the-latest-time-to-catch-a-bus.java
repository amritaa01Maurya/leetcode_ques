class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] pass, int cap) {
        int n = buses.length;
        int m = pass.length;
        
        Arrays.sort(buses);
        Arrays.sort(pass);
        Set<Integer> set = new HashSet<>();
        for(int p:pass){
            set.add(p);
        }
        
        int i=0;
        int j=0;
        int lastBusCap = 0;
        int latestTime = -1;//as late as possible 
        while(i<n){
            int c = 0;
            while(j < m && pass[j] <= buses[i] && c < cap){
                c++;
                j++;
                if(i == n - 1){
                    lastBusCap++;
                }
            }
            i++;
        }
        if(lastBusCap < cap){
            int time = buses[n-1];
            while(set.contains(time)){// check if our time matches any other passengers
                time--;
            }
            latestTime = Math.max(latestTime, time);
        }else{
            int time = pass[j-1] - 1;
            while(set.contains(time)){
                time--;
            }
            latestTime = Math.max(latestTime, time);
        }
        
        return latestTime;
    }
}