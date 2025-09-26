class Solution {
    public boolean canEat(int[] piles, int h, int mid) {
        int hours = 0;
        for(int i=0;i<piles.length;i++){
            hours += piles[i] / mid;
            if(piles[i] % mid != 0){
                hours++;
            }
            if(hours > h){
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 1000000000;
        int ans = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(canEat(piles, h ,mid)){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return ans;
    }
}