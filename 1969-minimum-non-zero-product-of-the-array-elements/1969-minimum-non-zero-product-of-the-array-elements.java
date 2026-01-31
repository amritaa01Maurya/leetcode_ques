class Solution {
    int mod = 1000000007;
    public long pow(long a, long b){
        long res = 1;
        b %= mod;
        while(a > 0){
            if((a & 1) == 1){
                res = (res * b) % mod;

            }
            b = (b * b) % mod;
            a >>= 1;
        }
        return res;
    }
    public int minNonZeroProduct(int p) {
        long q = pow(p, 2);// 2^p
        q--;// q =  2^p - 1;

        // to minimize product make (q/2) ele equal to 1 and (q/2) ele equal to (q - 1) by swapping bits with each other => and last ele remains same
        // we know (a-1)*(b+1) < a * b
        // (a-1-1)*(b+1+1) (a-1)*(b+1)
        // eg. p = 3 => q = 2^3 - 1 => 7
        // 7/2 => 3 ele => 1
        // 7/2 => 3 ele => (q - 1) => 6

        // 1   2   3      4  5   6     7
        // 001 010 011   100 101 110  111
        //      ^      swap   ^
        //     001           110

        // 001 001 011    100 110 110  111
        //          ^ swap ^
        //         001    110

        // 001 001 001    110 110 110  111
        // 1   1   1       6  6   6     7
        // min product => ((q - 1)^ (q/2)) * (q);
        // q/2 => (2^p - 1)/2 => 2^(p-1)
        long a = (1L << (p - 1)) - 1;
        long prod = pow(a, q - 1);

        long ans = (prod * (q % mod)) % mod;

        return (int)ans;

    }
}