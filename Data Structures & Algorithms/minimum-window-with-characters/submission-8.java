class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        int len = n;
        int[] map = new int[256];
        
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int minLength = Integer.MAX_VALUE, startIndex = -1;
        int i = 0, j = 0;

        while (j < m) {
            char c1 = s.charAt(j++);
            if (map[c1] > 0) {
               len--;
            }

            map[c1]--;

            while (len == 0) {
                if (j - i < minLength) {
                    minLength = j - i;
                    startIndex = i;
                 }
            
                char c2 = s.charAt(i++);
                map[c2]++;
            
            
                if (map[c2] > 0) {
                    len++;
                }
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
