class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();

        for (var token : tokens) {
            switch(token) {
                case "+", "-", "*", "/" -> {
                    var second = stack.pop();
                    var first = stack.pop();

                    stack.push(apply(token, first, second));
                }

                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private int apply(String token, int first, int second) {
        return switch(token) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> -1;
        };
    }
}
