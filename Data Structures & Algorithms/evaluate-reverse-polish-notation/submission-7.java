class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            switch (token) {
                case "+", "-", "*", "/" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(apply(first, second, token));
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    int apply(int first, int second, String token) {
        return switch (token) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "/" -> first / second;
            case "*" -> first * second;
            default -> 0;
        };
    }
}
