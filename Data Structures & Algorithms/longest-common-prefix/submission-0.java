class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        else if (strs.length==1) return strs[0];
        Arrays.sort(strs);
        String s1 = strs[0], s2 = strs[strs.length-1];
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) sb.append(s1.charAt(i));
            else break;
            ++i;
        }

        return sb.toString();
    }
}