class Solution {
    public String foreignDictionary(String[] words) {
        Map < Character, Set < Character >> graph = new HashMap < > ();
        Map < Character, Integer > inorder = new HashMap < > ();

        for (var word: words) {
            for (var c: word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet < > ());
                inorder.put(c, 0);
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
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inorder.put(c2, inorder.get(c2) + 1);
                    }

                    break;
                }
            }
        }

        Queue < Character > queue = new LinkedList < > ();
        for (char c: inorder.keySet()) {
            if (inorder.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);

            for (char neighbor: graph.get(c)) {
                inorder.put(neighbor, inorder.get(neighbor) - 1);

                if (inorder.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return sb.length() == inorder.size() ? sb.toString() : "";
    }
}