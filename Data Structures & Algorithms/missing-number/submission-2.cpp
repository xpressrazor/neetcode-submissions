class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int xorval = 0, n = nums.size();
        
        for (int i = 0; i < n; ++i) {
            xorval ^= i;
            xorval ^= nums[i];
        }
        xorval ^= n;

        return xorval;
    }
};
