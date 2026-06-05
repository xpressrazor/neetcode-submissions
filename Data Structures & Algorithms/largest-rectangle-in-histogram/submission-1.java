class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int prev = stack.pop();
                int area = (i - stack.peek() - 1) * heights[prev];
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        while (stack.peek() != -1) {
            int index = stack.pop();
            int area = (n - stack.peek() - 1) * heights[index];
            maxArea = Math.max(maxArea, area); 
        }

        return maxArea;
    }
}

/*
    // Monotonic increasing

    index   = [0, 1, 2, 3, 4, 5]
    heights = [7, 1, 7, 2, 2, 4]

    stack = [-1, ]
*/