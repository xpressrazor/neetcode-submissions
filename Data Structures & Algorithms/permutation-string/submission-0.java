class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        if (n < m) {
            return false;
        }

        if (m == 0 || n == 0) {
            return n == 0;
        }

        char[] map1 = new char[26];
        char[] map2 = new char[26];

        for (int i = 0; i < m; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(map1, map2)) {
            return true;
        }

        for (int i = 0; i < n - m; i++) {
            map2[s2.charAt(i) - 'a']--;
            map2[s2.charAt(i+m) - 'a']++;

            if (Arrays.equals(map1, map2)) {
                return true;
            }
        }

        return false;
    }
}
