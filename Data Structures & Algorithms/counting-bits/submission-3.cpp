class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> result(n+1,0);

        for (int i = 0; i <= n; ++i) {
            int x = i;
            int count = 0;
            while (x > 0) {
                ++count;
                x &= (x-1);
            }
            result[i] = count;
        }

        return result;
    }
};
