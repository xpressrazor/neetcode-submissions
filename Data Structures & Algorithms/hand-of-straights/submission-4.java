class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for (int k : map.keySet()) {
            int start = k;

            while (map.getOrDefault(start - 1, 0) > 0) {
                start--;
            }

            while (map.get(start) > 0) {
                for (int i = start; i < start + groupSize; i++) {
                    if (map.getOrDefault(i, 0) == 0) {
                        return false;
                    }

                    map.put(i, map.get(i) - 1);
                }
            }
        }

        return true;
    }
}
