class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i = 0, j = n-1;
        int leftMax = height[0], rightMax = height[n-1];
        int area = 0;

        while (i < j) {
            if (leftMax < rightMax) {
                i++;
                leftMax = Math.max(leftMax, height[i]);
                area += leftMax - height[i]; 
            } else {
                j--;
                rightMax = Math.max(rightMax, height[j]);
                area += rightMax - height[j];
            }
        }

        return area;
    }
}
