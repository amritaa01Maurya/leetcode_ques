class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minprice = prices[0];
        for (int i = 1; i < n; i++) {
            minprice = Math.min(minprice, prices[i]);
            int profit = prices[i] - minprice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}