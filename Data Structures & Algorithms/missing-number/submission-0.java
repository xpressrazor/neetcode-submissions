class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = 0;

        for (int i = 0; i < n; i++) {
            x ^= i;
            x ^= nums[i];
        }

        x ^= n;
        return x;
    }
}
