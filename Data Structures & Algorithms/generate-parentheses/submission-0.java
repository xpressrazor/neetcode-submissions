class Solution {
    List<String> result = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;    
        generate("", 0, 0);
        return result;
    }

    private void generate(String s, int left, int right) {
        if (left > n || right > n) {
            return;
        } else if (left == right && left == n) {
            result.add(s);
        } else if (right > left) { // if right is more than left, we already imbalance
            return;
        } else {
            generate(s + "(", left + 1, right);
            generate(s + ")", left, right + 1);
        }
    }
}
