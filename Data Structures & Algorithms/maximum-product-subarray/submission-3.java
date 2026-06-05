class Solution {
    public int maxProduct(int[] nums) {
        int min = 1, max = 1;
        int res = nums[0];

        for (int num : nums) {
            int tmp = num * max;
            max = Math.max(num, Math.max(num * min, num * max));
            min = Math.min(num, Math.min(num * min, tmp));
            res = Math.max(res, max);
        }

        return res;
    }
}
