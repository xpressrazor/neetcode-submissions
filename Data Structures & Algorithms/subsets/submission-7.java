class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());  

        return result;  
    }

    private void backtrack(int[] nums, int i, List<Integer> tmp) {
        if (i == nums.length) {
            result.add(new ArrayList<>(tmp));
        } else {
            tmp.add(nums[i]);
            backtrack(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
            backtrack(nums, i + 1, tmp);
        }
    }
}
