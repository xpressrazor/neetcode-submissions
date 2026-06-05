class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int mid = height[stack.pop()];

                if (!stack.isEmpty()) {
                    int right = height[i];
                    int left = height[stack.peek()];

                    int h = Math.min(left, right) - mid;
                    int w = i - stack.peek() - 1;

                    res += h * w;
                }
            }

            stack.push(i);
        }

        return res;
    }
}
