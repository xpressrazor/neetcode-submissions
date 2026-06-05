class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        return rob(nums, 0, n-1);
    }

    private int rob(int[] nums, int i, int j) {
        int prev = 0, max = 0;

        while (i <= j) {
            int tmp = Math.max(max, prev + nums[i]);
            prev = max;
            max = Math.max(max, tmp);
            i++;
        }

        return max;
    }
}
