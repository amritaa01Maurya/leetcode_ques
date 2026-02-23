class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k){
            return false;
        }
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append(s.charAt(i));
        }
        set.add(sb.toString());
        //int l = 0;
        for(int r=0;r<s.length();r++){
            sb.append(s.charAt(r));

            if(sb.length() > k){
                sb.deleteCharAt(0);
            }
            set.add(sb.toString());
        }

        if(set.size() == Math.pow(2, k)){
            return true;
        }
        return false;
    }
}