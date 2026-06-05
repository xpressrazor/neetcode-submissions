class Solution {
    public int reverse(int x) {
        int rev = 0;
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        while (x > 0) {
            int digit = x % 10;

            if (rev > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }

            rev = rev * 10 + digit;
            x /= 10;
        }

        return sign * rev;
    }
}
