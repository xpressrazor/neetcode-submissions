class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            if (nums[lo] < nums[hi]) {
                res = Math.min(res, nums[lo]);
                break;
            } 

            int mid = lo + ((hi - lo) >> 1);
            res = Math.min(res, nums[mid]);

            if (nums[lo] <= nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }
}
