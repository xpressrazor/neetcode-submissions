class Solution {
public:
    long long minEnd(int n, int x) {
        vector<int> xarr(64, 0);
        vector<int> narr(64, 0);
        --n;  // up to n-1, convert n and x to array and put 
        // next value of n from right on next 0 value position of x

        for (int i = 0; i < 32; ++i) {
            xarr[i] = (x>>i)&1;
            narr[i] = (n>>i)&1;
        }

        int yptr = 0;
        for (int i = 0; i < 63; ++i) {
            if (xarr[i] > 0) continue;
            xarr[i] = narr[yptr++];
        }

        long long res = 0;
        for (int i = 0; i < 64; ++i) {
            if (xarr[i] > 0) {
                res += (1L << i);
            }
        }

        return res;
    }
};