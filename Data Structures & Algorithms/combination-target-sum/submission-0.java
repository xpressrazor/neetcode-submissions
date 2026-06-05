class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        backtrack(nums, 0, target, new ArrayList<>());

        return result;    
    }

    private void backtrack(int[] nums, int start, int target, List<Integer> tmp) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= target) {
                tmp.add(nums[i]);
                backtrack(nums, i, target - nums[i], tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
