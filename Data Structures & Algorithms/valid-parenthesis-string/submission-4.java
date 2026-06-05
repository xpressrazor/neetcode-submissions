class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n+1][n+1];

        return checkValidString(s, 0, 0, memo);
    }

    private boolean checkValidString(String s, int index, int open, Boolean[][] memo) {
        if (open < 0) {
            return false;
        } else if (index == s.length()) {
            return open == 0;
        }

        if (memo[index][open] != null) {
            return memo[index][open];
        } else if (s.charAt(index) == '(') {
            return memo[index][open] = checkValidString(s, index + 1, open + 1, memo);
        } else if (s.charAt(index) == ')') {
            return memo[index][open] = checkValidString(s, index + 1, open - 1, memo);
        } else {
            return memo[index][open] = checkValidString(s, index + 1, open + 1, memo)
                || checkValidString(s, index + 1, open - 1, memo)
                || checkValidString(s, index + 1, open, memo);
        }
    }
}
