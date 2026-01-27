class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(new int[]{i, tickets[i]});
        }
        int time = 0;
        int totTktOfK = tickets[k];
        while(totTktOfK > 0 && !q.isEmpty()){
            int[] a = q.poll();
            int idx = a[0];
            int tkt = a[1] - 1;
            if(idx == k){
                totTktOfK--;
            }
            time++;
            if(tkt > 0){
                q.add(new int[]{idx, tkt});
            }
        }
        return time;
    }
}