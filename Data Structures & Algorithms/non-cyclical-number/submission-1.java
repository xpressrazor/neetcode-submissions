class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        int p = 1, l = 1;

        do {
            if (p == l) {
                slow = fast;
                p *= 2;
                l = 0;
            }
            l++;
            fast = getSquareSum(fast); 
        } while (slow != fast);

        return slow == 1;
    }

    private int getSquareSum(int n) {
        int sum = 0;

        while (n > 0) {
            int v = n % 10;
            sum += (v * v);
            n /= 10;
        }

        return sum;
    }
}
