class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();

    int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.n = candidates.length;

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> tmp) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
        } else if (start >= n || candidates[start] > target) {
            return;
        }

        for (int i = start; i < n; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            } else if (candidates[i] > target) {
                return;
            }

            tmp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
