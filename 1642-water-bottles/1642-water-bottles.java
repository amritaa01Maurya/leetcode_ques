class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totWaterBottle = numBottles;
        while( numBottles >= numExchange){
            int extraBottle = numBottles / numExchange;
            int emptyBottles = numBottles % numExchange;
            totWaterBottle += extraBottle;
            numBottles = extraBottle + emptyBottles;
        }
        return totWaterBottle;
    }
}