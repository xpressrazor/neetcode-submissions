class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // monotonic decreasing array
        // right [current ith element] and left element form boundary
        // that holds water that is above mid (recently extracted element from stack)
        // O(n), O(n)

        Stack<Integer> stack = new Stack<>();

        int res = 0;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int mid = height[stack.pop()];

                if (!stack.isEmpty()) {
                    int left = height[stack.peek()];
                    int right = height[i];

                    res += (Math.min(left, right) - mid) * (i - 1 - stack.peek());
                }
            }

            stack.add(i);
        }

        return res;
    }
}
