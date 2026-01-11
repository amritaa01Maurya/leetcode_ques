class Solution {
    public List<Integer> solve(String s) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() <= 2){
            ans.add(Integer.valueOf(s));
        }
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
               List<Integer> left = solve(s.substring(0,i));
               List<Integer> right = solve(s.substring(i+1));

                for(int l:left){
                    for(int r:right){
                        if(s.charAt(i) == '-'){
                            ans.add(l - r);
                        }else if(s.charAt(i) == '+'){
                            ans.add(l +r);
                        }else{
                            ans.add(l * r);
                        }
                    }
                }
            }
        }
        return ans;
    }
    public List<Integer> diffWaysToCompute(String s) {
        return solve(s);  
    }
}