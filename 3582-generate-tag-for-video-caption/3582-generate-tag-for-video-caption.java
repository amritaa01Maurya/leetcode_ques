class Solution {
    public String generateTag(String caption) {
        if(caption.isEmpty()){
            return "";
        }
        String[] str = caption.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        sb.append(str[0].toLowerCase());
        for(int i=1;i<str.length;i++){
            String s = str[i].substring(0,1).toUpperCase() + str[i].substring(1).toLowerCase();
            sb.append(s);
        }
        if(sb.length() > 100){
            return sb.substring(0, 100);
        }
        return sb.toString();
    }
}