class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    int n;

    public List<String> letterCombinations(String digits) {
        n = digits.length();
        if (n == 0) {
            return result;
        }
        
        dfs(digits, 0, new StringBuilder());
        return result;    
    }

    private void dfs(String digits, int index, StringBuilder sb) {
        if (index == n) {
            result.add(sb.toString());
        } else {
            int curDigit = digits.charAt(index) - '0';
            String letters = map[curDigit];

            for (char c : letters.toCharArray()) {
                sb.append(c);
                dfs(digits, index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
