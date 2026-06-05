class Solution {
    public int removeElement(int[] nums, int val) {
        int i = -1, j = 0, n = nums.length;
        while (j < n) {
            if (nums[j] != val) {
                ++i;
                nums[i] = nums[j];
            }

            ++j;
        }

        return i + 1;
    }
}