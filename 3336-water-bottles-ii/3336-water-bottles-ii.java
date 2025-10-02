class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int bottles = numBottles;
        int extra = 0;
        while(numBottles >= numExchange){
            numBottles -= numExchange;
            numBottles++;
            extra++;
            numExchange++;
        }
        return bottles + extra;
    }
}