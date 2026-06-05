class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      Map<Character, Integer> inorder = new HashMap<>();

      for (String word : words) {
        for (char c : word.toCharArray()) {
            graph.putIfAbsent(c, new HashSet<>());
            inorder.put(c, 0);
        }
      }

      for (int i = 0; i < words.length - 1; i++) {
        String word1 = words[i];
        String word2 = words[i+1];

        int len = Math.min(word1.length(), word2.length());

        if (word1.length() > word2.length() && word1.substring(0, len).equals(word2)) {
            return "";
        }

        for (int j = 0; j < len; j++) {
            if (word1.charAt(j) != word2.charAt(j)) {
                if (!graph.get(word1.charAt(j)).contains(word2.charAt(j))) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    inorder.put(word2.charAt(j), inorder.get(word2.charAt(j)) + 1);
                }
                break;
            }
        }
      }

      Queue<Character> queue = new LinkedList<>();
      for (char c : inorder.keySet()) {
        if (inorder.get(c) == 0) {
            queue.add(c);
        }
      }

      StringBuilder sb = new StringBuilder();
      while (!queue.isEmpty()) {
        char c = queue.poll();
        sb.append(c);

        for (char neighbor : graph.get(c)) {
            inorder.put(neighbor, inorder.get(neighbor) - 1);

            if (inorder.get(neighbor) == 0) {
                queue.add(neighbor);
            }
        }
      }

      return sb.length() == inorder.size() ? sb.toString() : "";
    }
}
