class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n = s3.length();
        if (n1 + n2 != n) {
            return false;
        }

        Boolean[][] memo = new Boolean[n1 + 1][n2 + 1];
        return match(s1, s2, s3, 0, 0, 0, memo);
    }

    boolean match(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        } else if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        } else if (memo[i][j] != null) {
            return memo[i][j];
        } else {
            boolean m1 = s1.charAt(i) == s3.charAt(k) && match(s1, s2, s3, i + 1, j, k + 1, memo);
            boolean m2 = s2.charAt(j) == s3.charAt(k) && match(s1, s2, s3, i, j + 1, k + 1, memo);
            return memo[i][j] = m1 || m2;
        }
    }
}
