class Solution {
    int n;
    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canJump(int[] nums) {
        n = nums.length;
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        } else if (i == n-1) {
            return true;
        }

        if (nums[i] == 0) {
            return false;
        }

        int end = Math.min(n-1, i + nums[i]);
        for (int j = i + 1; j <= end; j++) {
            if (dfs(nums, j)) {
                memo.put(i, true);
                return true;
            }
        }

        memo.put(i, false);
        return false;
    }
}
