class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = 1, r = 1, n = nums.length;

        int[] result = new int[n];

        for (int i = 0; i < n; ++i) {
            result[i] = l;
            l *= nums[i];
        }

        for (int i = n-1; i >= 0; --i) {
            result[i] *= r;
            r *= nums[i];
        }

        return result;
    }
}  
