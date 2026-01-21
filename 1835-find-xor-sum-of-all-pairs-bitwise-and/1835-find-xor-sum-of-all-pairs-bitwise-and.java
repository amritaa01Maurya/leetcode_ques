class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = 0;
        int xor2 = 0;
        /*
        [a, b, c] [x,y]
        =(a & x) ^ (a & y) ^ (b & x) ^ (b & y) ^ (c & x) ^ (c & y)
        ={a & (x ^ y)} ^ {b & (x ^ y)} ^ {c & (x ^ y)}
        ={(x ^ y) & (a ^ b)} ^ {c & (x ^ y)}
        ={(x ^ y) & (a ^ b ^ c)}
        = xorSum(arr1) & xorSum(arr2)
         */
        for(int a:arr1){
            xor1 ^= a;
        }
        for(int a:arr2){
            xor2 ^= a;
        }

        return xor1 & xor2;
    }
}