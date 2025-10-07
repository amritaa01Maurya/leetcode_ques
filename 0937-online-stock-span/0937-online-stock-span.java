class StockSpanner {
    Stack<Integer> s;
    List<Integer> l = new ArrayList<>();
    int i = 0;
    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        while(!s.isEmpty() && l.get(s.peek()) <= price){
            s.pop();
        }
        int ans = 0;
        if(i==0 && s.isEmpty()){
            ans = 1;
        }
        else if(s.isEmpty() && i > 0){
            ans = i + 1;
        }else{
            ans = i - s.peek();
        }
        l.add(price);
        s.push(i);
        i++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */