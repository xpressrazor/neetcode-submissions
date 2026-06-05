class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        } else {
            return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
        }
    }

    private int rob(int[] nums, int i, int j) {
        int max = 0, prev = 0;

        while (i <= j) {
            int cur = Math.max(max, prev + nums[i++]);
            prev = max;
            max = Math.max(max, cur);
        }

        return max;
    }
}
