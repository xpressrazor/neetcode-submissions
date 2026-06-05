class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
