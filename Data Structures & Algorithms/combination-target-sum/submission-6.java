class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, 0, target, new ArrayList<>());
        return result;    
    }

    private void backtrack(int[] nums, int start, int target, List<Integer> tmp) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        } else if (start >= nums.length || nums[start] > target) {
            return;
        }

        tmp.add(nums[start]);
        backtrack(nums, start, target - nums[start], tmp);
        tmp.remove(tmp.size() - 1);
        backtrack(nums, start + 1, target, tmp);
    }
}
