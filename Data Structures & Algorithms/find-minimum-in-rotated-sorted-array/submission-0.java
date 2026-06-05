class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            while (lo < hi && nums[lo] == nums[hi]) {
                lo++;
            } 
            
            if (nums[lo] <= nums[hi]) {
                return nums[lo];
            } else {
                int mid = lo + ((hi - lo) >> 1);

                if (nums[lo] <= nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }

        return -1;
    }
}
