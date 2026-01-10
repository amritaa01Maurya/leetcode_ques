class Solution {
    public boolean isPossible(int[] arr, long day, int m, int k) {
        int n = arr.length;
        int count = 0;
        int bouque = 0;
        for(int i=0;i<n;i++){
            if(arr[i] <= day){
                count++;
            }else{
                count = 0;
            }
            if(count == k){
                bouque++;
                count = 0;
            }

            if(bouque >= m){
                return true;
            }
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)k * m > n){
            return -1;
        }
        long l = 1;
        long h = 1000000000;
        long ans = -1;
        while(l <= h){
            long mid = l  + (h - l) /2;
            if(isPossible(bloomDay, mid, m, k)){
                ans = mid;
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return (int)ans;
    }
}