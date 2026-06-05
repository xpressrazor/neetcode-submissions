class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();

        for (var c : s.toCharArray()) {

            switch (c) {
                case '(', '{', '['-> stack.push(c);
                default -> {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    var top = stack.pop();
                    if ((c == ')' && top != '(')
                        || (c == '}' && top != '{')
                        || (c == ']' && top != '[')) {
                            return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
