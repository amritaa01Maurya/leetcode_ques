class Solution {
    class Info{
        String name;
        int min;
        int amt;
        String city;

        Info(String[] s){
            this.name = s[0];
            this.min = Integer.parseInt(s[1]);
            this.amt = Integer.parseInt(s[2]);
            this.city = s[3];
        }
    }
    public boolean invalid(List<Info> transList,Info info) {
        // amt > 1000 => invalid
        if(info.amt > 1000){
            return true;
        }

        // check trans list of a person if within 60 min there is trans in diff city, then it is also invalid
        for(Info l: transList){
            if(l == info){
                continue;
            }
            int timeDur = Math.abs(info.min - l.min);
            boolean sameCity = info.city.equals(l.city);
            if(timeDur <= 60 && !sameCity){
                return true;
            }
        }
        return false;
    }
    
    public List<String> invalidTransactions(String[] trans) {
        List<String> ans = new ArrayList<>();

        Map<String, List<Info>> map = new HashMap<>();// name , info(name, time, amt, city)

        for(String ts: trans){
            String[] s = ts.split(",");
            Info info = new Info(s);
            map.putIfAbsent(info.name, new ArrayList<>());
            map.get(info.name).add(info);
        }

        for(String ts:trans){
            String[] s = ts.split(",");
            Info info = new Info(s);
            if(invalid(map.get(info.name), info)){
                ans.add(ts);
            }
        }
        return ans;
    }
}