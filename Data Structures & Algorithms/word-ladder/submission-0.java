class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        //dict.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return steps;
                }

                char[] curArr = cur.toCharArray();

                for (int i = 0; i < curArr.length; i++) {
                    char prevChar = curArr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != prevChar) {
                            curArr[i] = c;
                        }

                        String curStr = new String(curArr);
                        if (dict.contains(curStr)) {
                            dict.remove(curStr);
                            queue.add(curStr);
                        }
                    }

                    curArr[i] = prevChar;
                }
            }
            steps++;
        }

        return 0;
    }
}
