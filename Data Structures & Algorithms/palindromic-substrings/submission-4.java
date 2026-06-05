class Solution {
    public int countSubstrings(String s) {
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append('#').append(c);
        }
        sb.append('#');

        int n = sb.length();
        int[] p = new int[n];

        int l = 0, r = 0;
        
        for (int i = 0; i < n; i++) {
            p[i] = i < r ? Math.min(r - i, p[l + r - i]) : 0;

            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n && sb.charAt(i - p[i] - 1) == sb.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }

        int res = 0;
        for (int count : p) {
            res += (count + 1) / 2;
        }

        return res;
    }
}
