class Solution {
    public int trap(int[] height) {
        int maxLeft = 0;
        int area = 0;

        for (int h : height) {
            maxLeft = Math.max(maxLeft, h);
            area += maxLeft - h;
        }

        int n = height.length;
        int maxRight = 0;

        for (int i = n-1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);

            if (maxRight == maxLeft) {
                break;
            }

            area -= maxLeft - maxRight;
        }

        return area;
    }
}
