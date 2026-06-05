class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n-1;
        int pivot = n;

        // adjust k for kth largest instead of kth smallest
        k = n - k;

        while (pivot != k) {
            pivot = partition(nums, l, r);

            if (pivot < k) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }

        return nums[pivot];
    }

    private int partition(int[] nums, int l, int r) {
        int pivotIndex = l;
        int pivot = nums[r];

        while (l < r) {
            if (nums[l] <= pivot) {
                swap(nums, pivotIndex, l);
                pivotIndex++;
            }

            l++;
        }

        swap(nums, pivotIndex, r);
        return pivotIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
