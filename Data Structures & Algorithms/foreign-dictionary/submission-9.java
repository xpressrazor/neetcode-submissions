class Solution {
    Map<Character, Set<Character>> graph = new HashMap<>();
    Map<Character, Boolean> visited = new HashMap<>();
    LinkedList<Character> result = new LinkedList<>();

    public String foreignDictionary(String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());

            if (word1.length() > word2.length() && word1.substring(0, len).equals(word2)) {
                return "";
            }

            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }

        // cycle and topological sort
        for (char c : graph.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }

        return sb.toString();
    }

    private boolean dfs(char c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        visited.put(c, true);
        
        for (char neighbor : graph.get(c)) {
            if (dfs(neighbor)) {
                return true;
            }
        }

        result.addFirst(c);
        visited.put(c, false);
        return false;
    }
}
