class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
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
            if (j > i && nums[j] == nums[j-1]) {
                continue;
            }

            list.add(nums[j]);
            backtrack(nums, j + 1, target - nums[j], list);
            list.remove(list.size() - 1);
        }
    }
}

