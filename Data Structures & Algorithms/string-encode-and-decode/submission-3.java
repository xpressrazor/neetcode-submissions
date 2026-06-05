class Solution {

    public String encode(List<String> strs) {
         StringBuilder sb = new StringBuilder();

        for (String str : strs) {
        sb.append(str.length() + ":" + str);
        }

        return sb.toString();

    }

    public List<String> decode(String s) {
         List<String> result = new ArrayList<>();

        if (s.isEmpty()) {
            return result;
        }

        int i = 0, n = s.length();

        while (i < n) {
            int j = s.indexOf(":", i);
            int len = Integer.parseInt(s.substring(i, j));

            String str = s.substring(j + 1, j + 1 + len);
            result.add(str);
            i = j + 1 + len;
        }

        return result;
    }
}
