class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] freq1 = new int[100001];
        int[] freq2 = new int[100001];
        freq1[0] = 0;
        freq2[0] = 0;
        for(int i=0;i<n;i++){
            if(i % 2 == 0){
                freq2[nums[i]]++;
            }else{
                freq1[nums[i]]++;
            }
        }
        int maxOdd = 0;
        int smaxOdd = 0;
        for(int i=1;i<100001;i++){
            if(freq1[i] > freq1[maxOdd]){
                smaxOdd = maxOdd;
                maxOdd = i;
            }else if (freq1[i] > freq1[smaxOdd]){
                smaxOdd = i;
            }
        }
        int maxEven = 0;
        int smaxEven = 0;
        for(int i=1;i<100001;i++){
            if(freq2[i] > freq2[maxEven]){
                smaxEven = maxEven;
                maxEven = i;
            }else if(freq2[i] > freq2[smaxEven]){
                smaxEven = i;
            }
        }

        int minrem = 0;
        if(maxOdd != maxEven){
            minrem = n - (freq2[maxEven] + freq1[maxOdd]);
        }else {    
            minrem = n - Math.max(freq1[maxOdd] + freq2[smaxEven], freq2[maxEven] + freq1[smaxOdd]);
        }
        return minrem;
    }
}