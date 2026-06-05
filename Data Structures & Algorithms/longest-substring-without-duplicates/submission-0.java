class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] map = new char[256];

        int n = s.length();
        int i = 0, j = 0;
        int maxLen = 0;

        while (j < n) {
            char c1 = s.charAt(j++);
            map[c1]++;

            while (map[c1] > 1) {
                char c2 = s.charAt(i++);
                map[c2]--;
            }

            maxLen = Math.max(maxLen, j - i);
        }

        return maxLen;
    }
}
