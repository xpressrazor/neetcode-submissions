class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            sb.append(str.length() + "#" + str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        if (str.length() == 0) {
            return result;
        }

        int i = 0, n = str.length();

        while (i < n) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + 1 + length));
             i = j + 1 + length;
        }

        return result;
    }
}
