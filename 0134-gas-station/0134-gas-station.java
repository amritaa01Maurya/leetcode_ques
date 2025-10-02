class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tot_gas = 0;
        int tot_cost = 0;
        for(int i=0;i<n;i++){
            tot_gas += gas[i];
            tot_cost += cost[i];
        }
        if(tot_gas < tot_cost){
            return -1;
        }
        int start = 0;
        int diff = 0;
        for(int i=0;i<n;i++){
            diff += gas[i] - cost[i];
            if(diff < 0){
                start = i + 1;
                diff = 0;
            }
        }
        return start;
    }
}