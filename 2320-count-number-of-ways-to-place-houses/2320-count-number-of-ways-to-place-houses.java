class Solution {
    int mod = 1000000007;
    public int countHousePlacements(int n) {
        if(n == 1){
            return 4;
        }

        long a = 1;
        long b = 2;
        for(int i=2;i<=n;i++){
            long c = a % mod + b % mod;
            a = b;
            b = c;
        }
        long ans = (b * b )% mod;
        return (int) ans % mod;
    }
}