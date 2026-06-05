class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = 1001;
        int[] map = new int[n];

        for (int i = 0; i < hand.length; i++) {
            map[hand[i]]++;
        }

        for (int i = 0; i < n; i++) {
            while (map[i] > 0) {
                for (int j = i; j < i + groupSize; j++) {
                    if (map[j] == 0) {
                        return false;
                    }
                    map[j]--;
                }
            }
        }

        return true;
    }
}
