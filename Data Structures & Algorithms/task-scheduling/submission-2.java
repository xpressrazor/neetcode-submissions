class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }

        int res = 0;

        while (!pq.isEmpty()) {
            List<Integer> tmpFreqList = new ArrayList<>();
            int count = n + 1;

            while (count > 0 && !pq.isEmpty()) {
                int f = pq.poll() - 1;
                
                if (f > 0) {
                    tmpFreqList.add(f);
                }

                count--;
                res++;
            }

            
            if (tmpFreqList.size() > 0) {
                pq.addAll(tmpFreqList);
            }

            if (pq.isEmpty()) {
                break;
            }

            res += count;
        }

        return res;
    }
}
