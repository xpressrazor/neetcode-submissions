class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int i = 0, j = m * n - 1;

        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            int r = mid / n;
            int c = mid % n;

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }
}
