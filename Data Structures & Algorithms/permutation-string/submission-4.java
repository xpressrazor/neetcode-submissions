class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        if (s1.length() > s2.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();

        for (int i = 0; i < m; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        for (int i = 0; i < n - m; i++) {
            freq2[s2.charAt(i) - 'a']--;
            freq2[s2.charAt(i + m) - 'a']++;

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}
