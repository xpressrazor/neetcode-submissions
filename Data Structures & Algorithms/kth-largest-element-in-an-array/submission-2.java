class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n-1;

        k = n - k;  // adjust kth smallest to kth largest
        int pivot = n;

        while (pivot != k) {
            pivot = parition(nums, l, r);

            if (pivot < k) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }

        return nums[pivot];
    }

    int parition(int[] nums, int l, int r) {
        int pivotIndex = l;
        int pivot = nums[r];

        while (l < r) {
            if (nums[l] <= pivot) {
                swap(nums, l, pivotIndex);
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
