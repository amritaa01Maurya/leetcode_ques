class Solution {
    public String arrangeWords(String text) {
        String[] str = text.split("\\s+");
        List<String> l = new ArrayList<>();
        for(String s:str){
            l.add(s);
        }
        l.sort((a,b) -> a.length() - b.length());
        String s = String.join(" ", l);
        return s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
    }
}