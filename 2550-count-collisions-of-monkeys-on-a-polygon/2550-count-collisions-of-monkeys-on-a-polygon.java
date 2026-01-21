class Solution {
    int mod = 1000000007;
    public int monkeyMove(int n) {
        // tot ways of monkey movement = 2^n
        // tot non-collision movement - 2 ( all monkeys clockwise, all monkeys anti-clockwise)
        // tot collision = 2^n - 2
        long ans = 1;
        long b = 2;
        while(n > 0){// binary exp 2^n
            if((n & 1) == 1){
                ans = (ans * b) % mod;
            }
            b = (b * b) % mod;
            n >>= 1;
        }
        return (int)(ans - 2 + mod) % mod;
    }
}