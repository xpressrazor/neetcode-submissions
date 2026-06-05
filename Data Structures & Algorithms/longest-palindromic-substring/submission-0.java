class Solution {
    int startIndex = -1;
    int minLength = 0;
    int n;

    public String longestPalindrome(String s) {
        n = s.length();

        for (int i = 0; i < n; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }

    private void expand(String s, int i, int j) {
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if (j - i - 1 > minLength) {
            startIndex = i + 1;
            minLength = j - i -1;
        }
    }
}
