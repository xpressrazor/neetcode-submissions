class Solution {
    public String longestPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            sb.append('#').append(c);
        }
        sb.append('#');

        int n = sb.length();
        int[] p = new int[n];

        int l = 0, r = 0;
        int start = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            p[i] = i < r ? Math.min(r - i, p[l + r - i]) : 0;

            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n && sb.charAt(i - p[i] - 1) == sb.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                start = (i - p[i]) / 2;
            }

            if (i + p[i] > r) {
                r = i + p[i];
                l = i - p[i];
            }
        }

        return s.substring(start, start + maxLen);
    }
}
