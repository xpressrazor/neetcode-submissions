class Solution {
    private List<String> result = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        generateParenthesis(0, 0, "");
        return result;    
    }

    private void generateParenthesis(int left, int right, String s) {
        if (left == n && right == n) {
            result.add(s);
        } else if (left > n || right > n || right > left) {
            return;
        } else {
            generateParenthesis(left + 1, right, s + "(");
            generateParenthesis(left, right + 1, s + ")");
        }
    }
}
