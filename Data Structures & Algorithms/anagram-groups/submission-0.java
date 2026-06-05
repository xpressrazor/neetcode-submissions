class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);

            map.computeIfAbsent(key, x -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for (String k : map.keySet()) {
            result.add(map.get(k));
        }
        
        return result;
    }

    private String getKey(String s) {
        char[] map = new char[26];
        
        for (char c : s.toCharArray()) {
            map[c-'a']++;
        }

        return new String(map);
    }
}
