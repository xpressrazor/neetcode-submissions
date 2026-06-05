class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task-'A']++;
        }

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : map) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int res = 0;

        while (!pq.isEmpty()) {
            int count = n + 1;
            List<Integer> tmpList = new ArrayList<>();

            while (count > 0 && !pq.isEmpty()) {
                res++;
                count--;

                int f = pq.poll() - 1;
                if (f > 0) {
                    tmpList.add(f);
                }
            }

            pq.addAll(tmpList);

            if (pq.isEmpty()) {
                break;
            }

            res += count;
        }

        return res;
    }
}
