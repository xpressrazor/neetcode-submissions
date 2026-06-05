class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        int x = 1, y = 1;
        int z = 1;
    
        for (int i = 2; i <= n; i++) {
            z = x + y;
            y = x;
            x = z;
        }

        return z;
    }
}
