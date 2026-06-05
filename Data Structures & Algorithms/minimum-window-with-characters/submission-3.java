class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int min_length = n;
        int[] freq = new int[256];
        
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int length = Integer.MAX_VALUE, start = -1;
        int i = 0, j = 0;
        while (j < m) {
            char c1 = s.charAt(j++);
            if (freq[c1] > 0) {
               min_length--;
            }

            freq[c1]--;

            while (min_length == 0) {
                if (j - i < length) {
                    length = j - i;
                    start = i;
                 }
            
                char c2 = s.charAt(i++);
                freq[c2]++;
            
            
                if (freq[c2] > 0) {
                    min_length++;
                }
            }
        }

        if (start != -1) {
            return s.substring(start, start + length);
        } else {
            return "";
        }
    }
}
