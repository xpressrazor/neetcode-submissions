class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int h : hand) {
            freqMap.put(h, freqMap.getOrDefault(h, 0) + 1);
        }

        Arrays.sort(hand);
        
        for (int h : hand) {
            if (freqMap.get(h) > 0) {
                for (int i = h; i < h + groupSize; i++) {
                    if (freqMap.getOrDefault(i, 0) == 0) {
                        return false;
                    }

                    freqMap.put(i, freqMap.get(i) - 1);
                }
            }
        }

        return true;
    }
}
