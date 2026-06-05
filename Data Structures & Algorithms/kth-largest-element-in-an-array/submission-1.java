class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        int pivot = nums.length;

        k = nums.length - k;

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
        int pivot = nums[r];
        int pivotIndex = l;

        while (l < r) {
            if (nums[l] <= pivot) {
                swap(nums, l, pivotIndex++);
            }

            l++;
        }

        swap(nums, pivotIndex, r);
        return pivotIndex;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
