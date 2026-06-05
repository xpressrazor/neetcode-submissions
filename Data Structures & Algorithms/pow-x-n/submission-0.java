class Solution {
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        
        double p1 = myPow(x, n/2);
        
        if (n % 2 == 0) {
            return p1 * p1;
        } else {
            if (n < 0) {
                return p1 * p1 / x;
            } else {
                return p1 * p1 * x;
            }
        }
    }
}
