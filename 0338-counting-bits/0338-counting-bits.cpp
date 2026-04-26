class Solution {
public:
    int bits(int n) {
        int count = 0;
        while(n > 0){
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    vector<int> countBits(int n) {
        vector<int> ans;
        for(int i=0;i<=n;i++){
            ans.push_back(bits(i));
        }

        return ans;
    }
};