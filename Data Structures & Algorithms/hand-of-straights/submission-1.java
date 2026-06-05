class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int h : hand) {
            freqMap.put(h, freqMap.getOrDefault(h, 0) + 1);
        }

        for (int h : hand) {
            int start = h;

            while (freqMap.getOrDefault(start - 1, 0) > 0) {
                start--;
            }

            while (start <= h) {
                while (freqMap.getOrDefault(start, 0) > 0) {
                    for (int i = start; i < start + groupSize; i++) {
                        if (freqMap.getOrDefault(i, 0) == 0) {
                            return false;
                        }

                        freqMap.put(i, freqMap.get(i) - 1);
                    }
                }
                start++;
            }
            
        }

        return true;
    }
}
