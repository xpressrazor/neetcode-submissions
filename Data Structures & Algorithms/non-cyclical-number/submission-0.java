class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;

       do {
        fast = getSquareSum(getSquareSum(fast));
        slow = getSquareSum(slow);
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
