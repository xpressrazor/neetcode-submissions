class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j = i + 1, k = n-1;

            while (j < k) {
                if (k < n-1 && nums[k] == nums[k+1]) {
                    k--;
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }

                if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
