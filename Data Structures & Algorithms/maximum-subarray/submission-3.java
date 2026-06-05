class Solution {
    public int maxSubArray(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return Integer.MIN_VALUE;
        }

        int mid = lo + ((hi - lo) >> 1);

        int leftSum = 0, rightSum = 0, curSum = 0;

        for (int i = mid - 1; i >= 0; i--) {
            curSum += nums[i];
            leftSum = Math.max(leftSum, curSum);
        }

        curSum = 0;
        for (int i = mid + 1; i <= hi; i++) {
            curSum += nums[i];
            rightSum = Math.max(rightSum, curSum);
        }

        return Math.max(dfs(nums, lo, mid - 1), 
            Math.max(dfs(nums, mid + 1, hi), leftSum + rightSum + nums[mid]));
    }
}
