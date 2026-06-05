class Solution {
    public boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }

    private boolean checkValidString(String s, int index, int open) {
        if (open < 0) {
            return false;
        } else if (index == s.length()) {
            return open == 0;
        }

        if (s.charAt(index) == '(') {
            return checkValidString(s, index + 1, open + 1);
        } else if (s.charAt(index) == ')') {
            return checkValidString(s, index + 1, open - 1);
        } else {
            return checkValidString(s, index + 1, open + 1)
                || checkValidString(s, index + 1, open - 1)
                || checkValidString(s, index + 1, open);
        }
    }
}
