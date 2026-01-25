class Solution {
    int mod = 1000000007;
    public long rangeSum(long a, long b) {
        long sum = b * (b + 1)/2 - a * (a + 1)/2;
        return sum;
    }
    public int maxProfit(int[] inventory, int orders) {
        int n = inventory.length;
        Arrays.sort(inventory);

        long sum = 0;
        int i = n-1;
        int count = 1;
        while(orders > 0){//take larger number first
            long b = inventory[i];
            long a = i == 0 ? 0 : inventory[i-1];
            if(count * (b - a) <= orders){
                sum = (sum + rangeSum(a , b) * count) % mod;
                orders -= count * (b - a);
            }else{
                long need = orders/count;
                long rem = orders % count;
                sum = (sum + (rangeSum(b - need, b) * count)) % mod;
                sum = (sum + rem * (b - need)) % mod;

                break;
            }

            count++;
            i--;

        }
        return (int)sum;
    }
}