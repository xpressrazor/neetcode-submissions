class Solution {
    public int trap(int[] height) {
        int sum = 0, tallest = 0;

        for (int h : height) {
            tallest = Math.max(tallest, h);
            sum += tallest - h;
        }

        int rightTallest = 0;
        for (int i = height.length - 1; i >= 0 && height[i] != tallest; i--) {
            rightTallest = Math.max(rightTallest, height[i]);
            sum -= tallest - rightTallest;
        }

        return sum;
    }
}
