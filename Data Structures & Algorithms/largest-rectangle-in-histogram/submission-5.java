class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int index = -1;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (index != -1 && (i == n || heights[i] <= heights[stack[index]])) {
                int height = heights[stack[index--]];
                int width = index == -1 ? i : i - 1 - stack[index];
                maxArea = Math.max(maxArea, height * width);
            }

            stack[++index] = i;
        }

        return maxArea;
    }
}
