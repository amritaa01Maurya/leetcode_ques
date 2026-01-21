class Solution {
    public int primeSubarray(int[] nums, int k) {
        int n = nums.length;
        boolean[] prime = new boolean[50001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= 50000; ++i) {
            if (prime[i]) {
                for (int j = i * i; j <= 50000; j += i) {
                    prime[j] = false;
                }
            }
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Deque<Integer> pos = new ArrayDeque<>();
        int l = 0;
        int count = 0;
        for (int r = 0; r < n; ++r) {
            if (prime[nums[r]]) {
                pos.addLast(r);
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            }
            while (!map.isEmpty() && map.lastKey() - map.firstKey() > k) {
                if(prime[nums[l]]){
                    map.put(nums[l], map.get(nums[l]) - 1);
                    if (map.get(nums[l]) == 0) {
                        map.remove(nums[l]);
                    }
                    pos.pollFirst();
                }
                l++;
            }
            if (pos.size() >= 2) {
                int last = pos.pollLast();
                int seclast = pos.peekLast();
                pos.addLast(last);
                count += seclast - l + 1;
            }
        }
        return count;
    }
}             