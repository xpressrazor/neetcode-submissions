class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length() + ":" + s);
        }

        return sb.toString();
    }

    // 4:neet4:code4:love3:you

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        if (str.length() == 0) {
            return result;
        }

        // 0 to : is length

        int i = 0;
        int n = str.length();

        while (i < n) {
            int j = str.indexOf(":", i);
            int len = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + 1 + len));
            i = j + len + 1;
        }

        return result;
    }
}
