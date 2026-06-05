class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        n = nums.length;
        Arrays.sort(nums);
        backtrack(nums, 0, target, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, int i, int target, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        } else if (i >= n || target < 0) {
            return;
        }

        for (int j = i; j < n; j++) {
            if (j > i && nums[j] == nums[j-1]) {
                continue;
            }

            list.add(nums[j]);
            backtrack(nums, j + 1, target - nums[j], list);
            list.remove(list.size() - 1);
        }
    }
}

