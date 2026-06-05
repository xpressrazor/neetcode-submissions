class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMaxHeight = height[0], rightMaxHeight = height[n-1];

        int i = 0, j = n-1;

        int res = 0;
        
        while (i < j) {
            if (leftMaxHeight < rightMaxHeight) {
                i++;
                leftMaxHeight = Math.max(leftMaxHeight, height[i]);
                res += leftMaxHeight - height[i];
            } else {
                j--;
                rightMaxHeight = Math.max(rightMaxHeight, height[j]);
                res += rightMaxHeight - height[j];
            }
        }

        return res;
    }
}
