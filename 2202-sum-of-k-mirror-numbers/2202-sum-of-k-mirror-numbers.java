class Solution {
    public boolean isPalindrome(String num) {
        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            if (num.charAt(l) != num.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public String basek(int k, long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.toString();
    }

    public long kMirror(int k, int n) {
        long tot_pal = 0L;
        int len = 1;
        while (n > 0) {
            int hf_len = (len + 1) / 2;
            long start = (long) Math.pow(10, hf_len - 1);
            long end = (long) Math.pow(10, hf_len) - 1;
            for (long i = start; i <= end; ++i) {
                String first_half = Long.toString(i);
                StringBuilder sb = new StringBuilder(first_half);
                String sec_half = sb.reverse().toString();
                String s = "";
                if (len % 2 == 0) {
                    s = first_half + sec_half;
                } else {
                    s = first_half + sec_half.substring(1);
                }
                String kthbase = basek(k, Long.parseLong(s));
                if (isPalindrome(kthbase)) {
                    tot_pal += Long.parseLong(s);
                    n--;
                    if(n == 0){
                        break;
                    }
                }
            }
            len++;
        }
        return tot_pal;
    }
}