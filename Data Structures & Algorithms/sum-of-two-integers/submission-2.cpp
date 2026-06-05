class Solution {
public:
    int getSum(int a, int b) {
        while (b != 0) {
            int c = a&b;
            int s = a^b;
            b = (c<<1);
            a = s;
        }

        return a;
    }
};
