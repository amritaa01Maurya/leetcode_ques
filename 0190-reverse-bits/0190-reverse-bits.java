class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        // 

        for(int i=0;i<32;i++){
            ans <<= 1; // left shift ans by 1 bit

            int bit = n & 1; // rightmost bit(lsb)
            
            ans |= bit; // include in ans
            n >>= 1;// right shift n by 1 bit;
        }
        return ans;
    }
}