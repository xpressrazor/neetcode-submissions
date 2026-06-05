class Solution {
    public int evalRPN(String[] tokens) {
        var tokenList = new ArrayList<>(Arrays.asList(tokens));
        return dfs(tokenList);
    }

    private int dfs(List<String> tokenList) {
        String token = tokenList.remove(tokenList.size() - 1);

        if (!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }

        int right = dfs(tokenList);
        int left = dfs(tokenList);

        return switch(token) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> 0;
        };
    }
}
