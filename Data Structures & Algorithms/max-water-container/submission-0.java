class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0, j = n-1;
        int maxArea = 0;

        while (i < j) {
            int area = Math.min(heights[i], heights[j]) * (j-i);
            maxArea = Math.max(maxArea, area);

            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
