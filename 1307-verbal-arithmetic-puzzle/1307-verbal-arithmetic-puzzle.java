class Solution {
    public boolean solve(String[] words, String result, int[] charMap, List<Character> arr, boolean[] nonzero, boolean[] mapped, int idx) {
        if(idx == arr.size()){
            return sumEq(charMap,words, result);
        }
        for(int i=0;i<=9;i++){
            if(!mapped[i]){
                if(nonzero[arr.get(idx)- 'A'] && i == 0) continue;
                charMap[arr.get(idx) - 'A'] = i;
                mapped[i] = true;

                if(solve(words, result, charMap, arr, nonzero, mapped, idx + 1)){
                    return true;
                }
                mapped[i] = false;
                charMap[arr.get(idx) - 'A'] = -1;
            }
        }
        return false;
    }
    public boolean sumEq(int[] charMap, String[] words, String result) {
        int sum = 0;
        for(String w:words){
            int s = 0;
            for(int i=0;i<w.length();i++){
                s = s * 10 + charMap[w.charAt(i)-'A'];
            }
            sum += s;
        }

        int res = 0;
        for(int i=0;i<result.length();i++){
            res = res * 10 + charMap[result.charAt(i) - 'A'];
        }

        return sum == res;
    }
    public boolean isSolvable(String[] words, String result) {
        Set<Character> set = new HashSet<>();
        boolean[] nonzero = new boolean[26];

        for(String s:words){
            nonzero[s.charAt(0)-'A'] =  s.length() < 2 ? false :true;
            for(char ch:s.toCharArray()){
                set.add(ch);
            }
        }

        nonzero[result.charAt(0)-'A'] = result.length() < 2 ? false: true;
        for(char ch: result.toCharArray()){
            set.add(ch);
        }

        List<Character> arr = new ArrayList<>(set);
        boolean[] mapped = new boolean[10];
        int[] charMap = new int[26];
        Arrays.fill(charMap, -1);

        return solve(words, result, charMap, arr, nonzero, mapped, 0);
    }
}