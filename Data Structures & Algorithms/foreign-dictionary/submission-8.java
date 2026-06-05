class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inorder = new HashMap<>();

        for (var word : words) {
            for (var c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inorder.put(c, 0);
            }
        }

        for (var i = 0; i < words.length - 1; i++) {
            var word1 = words[i];
            var word2 = words[i+1];
            var len = Math.min(word1.length(), word2.length());

            if (word1.length() > word2.length() && word1.substring(0, len).equals(word2)) {
                return "";
            }

            for (var j = 0; j < len; j++) {
                var c1 = word1.charAt(j);
                var c2 = word2.charAt(j);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inorder.put(c2, inorder.get(c2) + 1);
                    }

                    break;
                }
            }
        }

        var queue = new LinkedList<>();
        
        for (var c : inorder.keySet()) {
            if (inorder.get(c) == 0) {
                queue.add(c);
            }
        }

        var sb = new StringBuilder();
        
        while (!queue.isEmpty()) {
            var c = queue.poll();
            sb.append(c);

            for (var neighbor : graph.get(c)) {
                inorder.put(neighbor, inorder.get(neighbor) - 1);

                if (inorder.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return sb.length() == inorder.size() ? sb.toString() : "";
    }
}
