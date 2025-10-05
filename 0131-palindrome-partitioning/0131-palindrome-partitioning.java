class Solution {
    public boolean palindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void part(String s, List<List<String>> ll, List<String> l) {
        if(s.length() == 0){
            ll.add(new ArrayList<>(l));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String sub = s.substring(0, i);
            if(palindrome(sub)){
                l.add(sub);
                part(s.substring(i), ll, l);
                l.remove(l.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ll = new ArrayList<>();
        List<String> l = new ArrayList<>();
        part(s, ll, l);
        return ll;
    }
}