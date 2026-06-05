class Solution {
    Boolean[][] memo;
    int n;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        n = nums.length;

        for (int num : nums) {
            sum += num;
        }    

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        memo = new Boolean[n + 1][target + 1];

        return canPartition(nums, 0, target);
    }

    private boolean canPartition(int[] nums, int i, int target) {
        if (target == 0) {
            return true;
        } else if (target < 0 || i >= n) {
            return false;
        } else if (memo[i][target] != null) {
            return memo[i][target];
        } else {
            return memo[i][target] = canPartition(nums, i + 1, target - nums[i]) 
                || canPartition(nums, i + 1, target);
        }
    }
}
