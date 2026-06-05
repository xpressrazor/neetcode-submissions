class Solution {
    static final int INF = Integer.MAX_VALUE / 4;
    int n;
    Map<Integer, Integer> memo = new HashMap<>();

    public int jump(int[] nums) {
        n = nums.length;
        return dfs(nums, 0);    
    }

    private int dfs(int[] nums, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        } else if (i == n-1) {
            return 0;
        } else if (nums[i] == 0) {
            return INF;
        }

        int res = INF;
        int end = Math.min(n-1, i + nums[i]);
        for (int j = i + 1; j <= end; j++) {
            res = Math.min(res, 1 + dfs(nums, j));
        }

        memo.put(i, res); 
        return res;
    }
}
