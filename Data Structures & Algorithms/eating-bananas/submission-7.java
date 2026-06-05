class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Arrays.stream(piles).max().getAsInt();
        int res = 0;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            int total = 0;
            for (int p : piles) {
                total += Math.ceil(p / (double) mid);
            }

            if (total <= h) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
}
