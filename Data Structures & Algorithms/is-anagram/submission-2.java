class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c-'a']++;
        }

        for (char c : t.toCharArray()) {
            if (f[c-'a'] > 0) f[c-'a']--;
            else return false;
        }

        return true;
    }
}
