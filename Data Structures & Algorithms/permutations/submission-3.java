class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        backtrack(nums, 0);

        return result;
    }

    private void backtrack(int[] nums, int i) {
        if (i == n) {
            // slow
            // result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            
            result.add(list);
            return;
        }

        for (int j = i; j < n; j++) {
            swap(nums, i, j);
            backtrack(nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
