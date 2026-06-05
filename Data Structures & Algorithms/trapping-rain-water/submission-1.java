class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int rain = 0;

        for (int i = 0; i < n; i++) {
            int tallestLeft = 0, tallestRight = 0;

            for (int j = 0; j <= i; j++) {
                tallestLeft = Math.max(tallestLeft, height[j]);
            }

            for (int j = i; j < n; j++) {
                tallestRight = Math.max(tallestRight, height[j]);
            }

            rain += Math.min(tallestLeft, tallestRight) - height[i];
        }

        return rain;
    }
}
