class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        List<String> ll = new ArrayList<>();
        int l = 0;
        int one = 0;
        for (int r = 0; r < n; r++) {
            if (s.charAt(r) == '1') {
                one++;
            } else {
                one--;
            }
            if (one == 0) {
                String sb = s.substring(l + 1, r);
                ll.add("1" + makeLargestSpecial(sb) + "0");
                l = r + 1;
            }
        }
        ll.sort(Collections.reverseOrder());
        return String.join("", ll);
    }
}