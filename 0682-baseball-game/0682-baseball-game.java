class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            String s = operations[i];
            if(s.charAt(0) == 'C'){
                st.pop();
            }
            else if(s.charAt(0) == 'D'){
                int val = st.peek();
                st.push(2 * val);
            }
            else if(s.charAt(0) == '+'){
                int a = st.pop();
                int b = st.pop();
                st.push(b);
                st.push(a);
                st.push(a + b);
            }else{
                int val = Integer.parseInt(s);
                st.push(val);
            }
        }
        int score = 0;
        while(!st.isEmpty()){
            score += st.pop();
        }
        return score;
    }
}