class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 1000000000;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (canFinish(piles, mid, h)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int count = 0;

        for (int p : piles) {
            count += p/k;

            if (p % k != 0) {
                count++;
            }

            if (count > h) {
                return false;
            }
        }

        return true;
    }
}
