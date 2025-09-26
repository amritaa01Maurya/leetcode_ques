class Solution {
    public int countPrimes(int n) {
        if(n <= 2 ){
            return 0;
        }
        boolean[] non_prime = new boolean[n];
        non_prime[0] = non_prime[1] = true;
        for(int i=2;i*i<n;i++){
            if(!non_prime[i]){
                for(int j=2;i*j<n;j++){
                    non_prime[i*j] = true;
                }
            }
        }
        int count = 0;
        for(boolean np:non_prime){
            if(!np){
                count++;
            }
        }
        return count;
    }
}