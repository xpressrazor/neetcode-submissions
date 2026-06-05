class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, r = points.length - 1;
        int pivot = points.length;

        while (pivot != k) {
            pivot = partition(points, l, r);
            
            if (pivot < k) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }

        int[][] res = new int[k][2];
        System.arraycopy(points, 0, res, 0, k);
        
        return res;
    }

    private int partition(int[][] points, int l, int r) {
        int pivotIndex = l;
        int pivotDistance = getOrigDistanceSq(points[r]);

        while (l < r) {
            int curDistance = getOrigDistanceSq(points[l]);

            if (curDistance <= pivotDistance) {
                swap(points, l, pivotIndex);
                pivotIndex++;
            }

            l++;
        }

        swap(points, pivotIndex, r);
        return pivotIndex;
    }

    private int getOrigDistanceSq(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
