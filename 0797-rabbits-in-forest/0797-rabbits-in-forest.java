class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        Arrays.sort(answers);
        int prevRabbit = answers[0];
        int skip = answers[0];
        int tot_rabbit = answers[0] + 1;
        for(int i=1;i<n;i++){
            if(answers[i] == prevRabbit && skip > 0){
                skip--;
            }else{
                prevRabbit = answers[i];
                skip = answers[i];
                tot_rabbit += answers[i] + 1;
            }
        }
        return tot_rabbit;
    }
}