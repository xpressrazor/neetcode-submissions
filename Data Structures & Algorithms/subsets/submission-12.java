class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        backtrack(nums, 0, new ArrayList<>());

        return result;    
    }

    private void backtrack(int[] nums, int i, List<Integer> list) {
        if (i == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        backtrack(nums, i + 1, list);
        list.remove(list.size() - 1);

        backtrack(nums, i + 1, list);
    }
}
