class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Arrays.stream(piles).max().getAsInt();
        int res = hi;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int totalTime = 0;

            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }

            if (totalTime <= h) {
                hi = mid - 1;
                res = mid;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
}
