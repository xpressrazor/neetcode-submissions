class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        this.n = nums.length;
        backtrack(nums, 0, new ArrayList<>());        
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> list) {
        result.add(new ArrayList<>(list));

        if (i == n) {
            return;
        }

        for (int j = i; j < n; j++) {
            list.add(nums[j]);
            backtrack(nums, j + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
