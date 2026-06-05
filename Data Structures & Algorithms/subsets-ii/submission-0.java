class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.n = nums.length;
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));

        for (int i = start; i < n; i++) {
            
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            tmp.add(nums[i]);
            backtrack(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
