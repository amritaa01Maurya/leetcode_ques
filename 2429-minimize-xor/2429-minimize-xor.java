class Solution {
    public int countSetBit(int n) {
        int count = 0;
        while(n > 0){
            n =  n & (n - 1);
            count++;
        }
        return count;
    }
    public int minimizeXor(int num1, int num2) {
        int setBit = countSetBit(num2);
        int ans = 0;
        for(int i=30;i>=0;i--){
            if(((1 << i) & num1) != 0){
                ans |= (1 << i);
                setBit--;
                if(setBit == 0){
                    return ans;
                }
            }
        }
        for(int i=0;i<31;i++){
            if(((1 << i) & num1) == 0){
                ans |= (1 << i);
                setBit--;
                if(setBit == 0){
                    return ans;
                }
            }
        }
        return ans;
    }
}