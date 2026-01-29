class Solution {
    public boolean isValid(long mid, long[] diff, int r, int k) {
        int n = diff.length;
        long cumSum = 0;
        for(int i=0;i<n;i++){// for mid to be maximum all val must be equal or greater than mid
            cumSum += diff[i];
            if(cumSum < mid){
                long need = mid - cumSum;
                if(need > k){
                    return false;
                }
                k -= need;
                cumSum += need;
                if(i + 2 * r + 1 < n){//update the stations in range, choose that city which cover most city
                    diff[i+2*r+1] -= need; // update the diff 
                }
            }
        }
        return true;
    }
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        long[] diff = new long[n];// diff array to cal each station powers => its cum sum at ith gives power of ith city
        for(int i=0;i<n;i++){
            diff[Math.max(0, i - r)] += stations[i];

            if(i + r + 1 < n){
                diff[i+r+1] -= stations[i];
            }
        }

        long l = Long.MAX_VALUE;
        long h = 0;
        long sum = 0;
        for(long d:diff){
            sum += d;
            l = Math.min(l, sum);// min power
        }

        
        h = l + k; // max power

        long ans = l;
        //binary search on powers
        while(l <= h){
            long mid = l + (h - l)/2;
            long[] temp = diff.clone();// make a copy of the diff
            if(isValid(mid, temp, r, k)){
                ans = mid;
                l = mid + 1;//maximize
            }else{
                h = mid - 1;
            }
        }
        return ans;
    }
}