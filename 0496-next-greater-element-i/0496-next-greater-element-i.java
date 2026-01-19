class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i =n -1;i>=0;i--){
            while(!st.isEmpty() && nums2[i] >= nums2[st.peek()]){
                st.pop();
            }
            int NGE = st.isEmpty() ? -1: nums2[st.peek()];
            map.put(nums2[i], NGE);
            st.push(i);
        }

        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}