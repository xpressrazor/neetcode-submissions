class Solution {
    public int evalRPN(String[] tokens) {
        var tokenList = new ArrayList<>(Arrays.asList(tokens));
        return dfs(tokenList);
    }

    private int dfs(List<String> tokenList) {
        var token = tokenList.remove(tokenList.size() - 1);

        if (!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }

        int second = dfs(tokenList);
        int first = dfs(tokenList);

        return switch(token) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0; 
        };
    }
}
