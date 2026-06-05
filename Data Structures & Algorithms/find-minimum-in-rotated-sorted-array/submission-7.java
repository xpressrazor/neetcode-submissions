class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int res = Integer.MAX_VALUE;

        while (lo <= hi) {
            if (nums[lo] <= nums[hi]) {
                return Math.min(res, nums[lo]);
            } else {
                int mid = lo + ((hi - lo) >> 1);
                res = Math.min(res, nums[mid]);

                if (nums[lo] <= nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return res;
    }
}
