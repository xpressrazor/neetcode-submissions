class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> tmp = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    tmp.add(nums[j]);
                }
            }

            result.add(tmp);
        }

        return result;
    }
}
