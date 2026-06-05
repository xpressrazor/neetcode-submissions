class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int max = 0, len = 0;
        int i = 0, j = 0;
        char[] map = new char[256];

        while (j < n) {
            char c1 = s.charAt(j++);
            map[c1]++;

            max = Math.max(max, map[c1]);

            while (j - i - max > k) {
                char c2 = s.charAt(i++);
                map[c2]--;
            }

            len = Math.max(len, j - i);
        }

        return len;
    }
}
