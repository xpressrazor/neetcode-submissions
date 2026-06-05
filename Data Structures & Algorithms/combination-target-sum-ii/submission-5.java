class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] candidates, int target, int i, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        } else if (target < 0 || i == n) {
            return;
        }

        for (int j = i; j < n; j++) {
            if (j > i && candidates[j] == candidates[j-1] || candidates[j] > target) {
                continue;
            }

            list.add(candidates[j]);
            backtrack(candidates, target - candidates[j], j + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
