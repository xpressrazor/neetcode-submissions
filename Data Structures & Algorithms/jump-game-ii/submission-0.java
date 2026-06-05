class Solution {
    public int jump(int[] nums) {
        int max = 0, range = 0;
        int n = nums.length;
        int steps = 0;

        for (int i = 0; i < n-1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == range) {
                range = max;
                steps++;
            }
        }

        return steps;
    }
}
