class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, top = 0, right = n-1, bottom = m-1;
        
        List<Integer> result = new ArrayList<>();

        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            if (invalidBoundary(top, left, right, bottom)) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (invalidBoundary(top, left, right, bottom)) {
                break;
            }

            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            if (invalidBoundary(top, left, right, bottom)) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;

            if (invalidBoundary(top, left, right, bottom)) {
                break;
            }
        }

        return result;
    }

    private boolean invalidBoundary(int top, int left, int right, int bottom) {
        return top > bottom || left > right;
    }
}
