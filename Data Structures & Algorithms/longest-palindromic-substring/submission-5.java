class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }

        int n = sb.length();
        int[] p = new int[n];

        int l = 0, r = 0;
        int center = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            p[i] = i < r ? Math.min(r - i, p[l + r - i]) : 0;
            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && sb.charAt(i + p[i] + 1) == sb.charAt(i - p[i] - 1)) {
                p[i]++;
            }

            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                center = i;
            }
        }

/*
        
        int maxLen = 0, center = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                center = i;
            }
        }
*/
        int start = (center - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
