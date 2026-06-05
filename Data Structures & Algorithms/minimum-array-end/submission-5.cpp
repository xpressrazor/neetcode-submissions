class Solution {
public:
    long long minEnd(int n, int x) {
        long long res = x;
        --n;        // we need to calculate for n-1
        int i = 0;
        
        while (n > 0) {
            if ((res&(1LL<<i)) == 0) { // if ith bit is 0 in x
                if (n&1) {       // if n's 0th bit is set, add it to x at ith position
                    res |= (1LL<<i);
                }
                n >>= 1;        // divide n by 2 to get rid of LSB
            }
            ++i;                // let's move to next bit of x
        }
        
        return res;
    }
};