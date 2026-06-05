class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List[] lists = new ArrayList[1001];

        for (int k1 : freqMap.keySet()) {
            int f = freqMap.get(k1);

            if (lists[f] == null) {
                lists[f] = new ArrayList<>();
            }

            lists[f].add(k1);
        }

        int[] res = new int[k];
        int ptr = 0;

        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] != null) {
                for (Object j : lists[i]) {
                    res[ptr++] = (int) j;

                    if (ptr == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}
