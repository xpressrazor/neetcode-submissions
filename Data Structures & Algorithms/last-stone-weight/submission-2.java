class Solution {
    public int lastStoneWeight(int[] stones) {
        int max = Arrays.stream(stones).max().getAsInt();
        int[] bucket = new int[max + 1];

        for (int stone : stones) {
            bucket[stone]++;
        }

        int first = max;

        while (first > 0) {
            if (bucket[first] == 0) {
                first--;
                continue;
            }

            bucket[first]--;
            int second = first;
            
            while (second > 0 && bucket[second] == 0) {
                second--;
            }

            if (second == 0) {
                return first;
            }

            bucket[second]--;
            bucket[first-second]++;
        }

        return first;
    }
}
