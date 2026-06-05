class Solution {
public:
    int getSum(int a, int b) {
        while (b != 0) {
            int sum = a^b, carry = (a&b)<<1;
            a = sum;
            b = carry;
        }

        return a;
    }
};

/*
    a = 4, b = 7
    a = 100, b = 111
    s = 100^111 = 011, c = 100&111<<1 = 1000, a = s, b = c

    a = 11, b = 1000
    s = 0011^1000 = 1011, c = 0
*/
