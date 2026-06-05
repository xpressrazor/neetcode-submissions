class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, 0, target, new ArrayList<>());
        return result;    
    }

    private void backtrack(int[] nums, int i, int target, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        } else if (i >= nums.length || target < 0) {
            return;
        }

        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            backtrack(nums, j, target - nums[j], list);
            list.remove(list.size() - 1);
        }
    }
}
