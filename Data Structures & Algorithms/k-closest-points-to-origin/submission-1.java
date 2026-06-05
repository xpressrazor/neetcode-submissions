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
        System.arraycopy(points, 0, res, 0, k); // copy first k
        return res;
    }

    int partition(int[][] points, int l, int r) {
        int pivotIndex = r;
        int pivotDistance = points[r][0] * points[r][0] + points[r][1] * points[r][1];

        int p = l;

        while (l < r) {
            int curDistance = points[l][0] * points[l][0] + points[l][1] * points[l][1];
            if (curDistance <= pivotDistance) {
                swap(points, p, l);
                p++;
            }

            l++;
        }

        swap(points, p, r);
        return p;
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
