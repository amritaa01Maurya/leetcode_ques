class Solution {
    public int largestVariance(String s) {
        int n = s.length();
        int maxvar = 0;
        Set<Character> set = new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        }
        for(char f1='a';f1<='z';f1 += 1){
            for(char f2='a';f2<='z';f2 += 1){
                if(f1 == f2 || !set.contains(f1) || !set.contains(f2)) continue;
                int c1 = 0;
                int c2 = 0;
                boolean seenChar2 = false;
                for(int i=0;i<n;i++){
                    if(s.charAt(i) == f1){
                        c1++;
                    }
                    if(s.charAt(i) == f2){
                        c2++;
                    }

                    if(c2 > 0){
                        maxvar = Math.max(maxvar, c1 - c2);
                    }else if(seenChar2){
                        maxvar = Math.max(maxvar, c1 - 1);
                    }

                    if(c1 - c2 < 0){// for(b,a) -> aababbb -> 
                        c1 = 0;
                        c2 = 0;
                        seenChar2 = true;
                    }
                }
            }
        }
        return maxvar;
    }
}