class Solution {
    public int digProduct(int n) {
        int pro = 1;
        while(n > 0){
            int r = n % 10;
            pro *= r;
            n /= 10;
        }
        return pro;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            if(digProduct(i) % t == 0){
                return i;
            }
        }
        return -1;
    }
}