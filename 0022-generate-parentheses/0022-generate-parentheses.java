class Solution {
    public void generator(int n, int open, int close, String ans, List<String> l) {
        if(open == n && open == close){
            l.add(ans);
            return;
        }
        if(open > n || close > open){
            return;
        }
        generator(n, open + 1, close, ans + "(", l);
        generator(n, open, close + 1, ans + ")", l);
    }
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        generator(n, 0,0,"", l);

        return l;
    }
}