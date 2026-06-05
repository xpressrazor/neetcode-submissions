class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // monotonic decreasing array
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int mid = height[stack.pop()];
                
                if (!stack.isEmpty()) {
                    int left = height[stack.peek()];
                    int right = height[i];

                    res += (Math.min(left, right) - mid) * (i - stack.peek() - 1);
                }
            }
            
            stack.push(i);
        }

        return res;
    }
}
