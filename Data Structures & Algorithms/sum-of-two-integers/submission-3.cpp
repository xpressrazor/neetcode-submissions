class Solution {
public:
    int getSum(int a, int b) {
        while (b != 0) {
            int c = a&b;
            int s = a^b;
            a = s;
            b = c << 1;
        }

        return a;
    }
};
