class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length() + "#" + str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0, n = str.length();
        List<String> result = new ArrayList<>();

        while (i < str.length()) {
            int num = 0;    
            while (i < n && str.charAt(i) != '#') {
                num = num * 10 + str.charAt(i) - '0';
                ++i;
            }

            result.add(str.substring(i + 1, i + 1 + num));
            i = i + 1 + num;
        }

        return result;
    }
}
