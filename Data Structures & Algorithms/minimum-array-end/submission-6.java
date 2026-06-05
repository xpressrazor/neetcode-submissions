class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        --n;
        int i = 0;
        while (n>0) {
            if ((ans&(1L<<i))==0) {
                if ((n&1)==1) ans |= (1L<<i);
                n >>= 1;
            }
            ++i;
        }

        return ans;
    }
}