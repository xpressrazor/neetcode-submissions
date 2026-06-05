class Solution {
public:
    int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = abs(x);
        int rev = 0;

        while (x > 0) {
            int n = x%10;
            int v = (INT_MAX-n)/10;
            if (v < rev) return 0;
            rev = rev * 10 + n;
            x /= 10;
        }

        return sign * rev;
    }
};
