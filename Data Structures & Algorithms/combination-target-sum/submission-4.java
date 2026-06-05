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
        } else if (start >= nums.length) {
            return;
        }

        /*
        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= target) {
                tmp.add(nums[i]);
                backtrack(nums, i, target - nums[i], tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
        */
        
        
        if (nums[start] <= target) {
            tmp.add(nums[start]);
            backtrack(nums, start, target - nums[start], tmp);
            tmp.remove(tmp.size() - 1);
        }
        
        backtrack(nums, start + 1, target, tmp);
    }
}
