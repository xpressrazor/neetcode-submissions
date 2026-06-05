class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return steps;
                }

                char[] curArr = cur.toCharArray();

                for (int i = 0; i < curArr.length; i++) {
                    char prev = curArr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != prev) {
                            curArr[i] = c;

                            String newWord = new String(curArr);
                            
                            if (dict.contains(newWord)) {
                                dict.remove(newWord);
                                queue.add(newWord);
                            }
                        }
                    }
                    
                    curArr[i] = prev;
                }

            }
        }

        return 0;
    }
}
