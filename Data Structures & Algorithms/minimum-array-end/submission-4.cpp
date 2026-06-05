class Solution {
public:
    long long minEnd(int n, int x) {
        long long ans = x;
        --n;
        int i = 0;

        while (n > 0) {
            if ((ans&(1LL<<i))==0) {
                if (n&1) ans |= (1LL<<i);
                n >>= 1;
            }
            ++i;
        }

        return ans;
    }
};