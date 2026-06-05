class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List[] bucket = new List[1001];
        for (int key : map.keySet()) {
            int f = map.get(key);
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(key);
        }

        int[] r = new int[k];
        int p = 0;

        for (int i = 1000; i >= 0 && p < k; --i) {
            if (bucket[i] != null) {
                for (Object b : bucket[i]) {
                    Integer v = (Integer) b;
                    r[p++] = v;
                    if (p == k) break;
                }
            }
        }

        return r;
    }
}