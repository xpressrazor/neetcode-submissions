class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;

        for (int num : nums) {
           sum = Math.max(sum + num, num);
           max = Math.max(max, sum);
        }

        return max;
    }
}
