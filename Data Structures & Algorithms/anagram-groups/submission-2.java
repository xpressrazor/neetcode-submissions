class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            map.computeIfAbsent(key, x -> new ArrayList<>()).add(str);
        }

        List<List<String>> resultList = new ArrayList<>();
        for (String k : map.keySet()) {
            resultList.add(map.get(k));
        }

        return resultList;
    }

    private String getKey(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c-'a']++;
        }

        return Arrays.toString(f);
    }
}
