class Solution {
    public int countBit(int n) {
        int count = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n >>= 1;
        }
        return count;
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();

        for(int i=0;i<=11;i++){// hours range
            int bit = countBit(i);
            for(int j=0;j<60;j++){// min range
                StringBuilder sb = new StringBuilder();
                if(bit + countBit(j) == turnedOn){
                    sb.append(i+"").append(":");
                    if(j >= 0 && j < 10){
                        sb.append("0"+j);
                    }else{
                        sb.append(""+j);
                    }
                }
                if(sb.isEmpty()) continue;
                ans.add(sb.toString());
            }
            
        }
        return ans;
    }
}