class Solution {
public:
    double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double u = myPow(x, n/2);
        u = u*u;
        if (n < 0) return 1/myPow(x,-n);
        else if (n%2==1) return u * x;
        else return u;
    }
};
