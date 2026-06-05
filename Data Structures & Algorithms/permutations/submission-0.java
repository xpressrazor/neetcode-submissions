class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        permute(nums, 0);
        return result;    
    }

    private void permute(int[] nums, int start) {
        if (start == n) {
            List<Integer> tmp = new ArrayList<>();

            for (int num : nums) {
                tmp.add(num);
            }

            result.add(tmp);
            return;
        }

        for (int i = start; i < n; i++) {
            swap(nums, start, i);
            permute(nums, start + 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
