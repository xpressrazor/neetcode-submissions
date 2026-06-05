class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;    
    }

    private void backtrack(int[] nums, int start, List<Integer> tmp) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[start]);
        backtrack(nums, start + 1, tmp);
        tmp.remove(tmp.size() - 1);
        backtrack(nums, start + 1, tmp);
    }
}
