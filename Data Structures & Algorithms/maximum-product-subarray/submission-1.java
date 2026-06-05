class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0];
        int n = nums.length;
        int ans = nums[0];
        
        for (int i = 1; i < n; i++) {
            int curMin = min, curMax = max;
            int num = nums[i];

            if (num < 0) {
                min = Math.min(num, curMax * num);
                max = Math.max(num, curMin * num);
            } else {
                min = Math.min(num, curMin * num);
                max = Math.max(num, curMax * num);
            }
            ans = Math.max(ans, max);
        }

        return ans;
    }
}
