class Solution {
    public int characterReplacement(String s, int k) {
        var n = s.length();
        int i = 0, j = 0;
        char[] map = new char[256];
        int m = 0;
        int longest = 0;
        int max = 0;

        while (j < n) {
            char c1 = s.charAt(j++);

            map[c1]++;
            max = Math.max(max, map[c1]);

            while (j - i - max > k) {
                char c2 = s.charAt(i++);

                map[c2]--;
            }

            longest = Math.max(longest, j - i);
        }

        return longest;
    }
}
