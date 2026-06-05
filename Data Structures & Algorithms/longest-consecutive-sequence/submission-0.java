class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        Arrays.sort(nums);

        int count = 1;
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            } else if (nums[i] == nums[i-1] + 1) {
                count++;
            } else {
                count = 1;
            }

            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }
}
