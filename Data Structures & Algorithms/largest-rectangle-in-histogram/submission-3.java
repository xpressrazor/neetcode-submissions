class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && 
                (i == n || heights[i] <= heights[stack.peek()])) {
                
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
