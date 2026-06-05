class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;

        int lo = 1, hi = 1000000000;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            
            if (cancomplete(piles, mid, h)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean cancomplete(int[] piles, int k, int h) {
        int res = 0;
        for (int p : piles) {
            res += (p/k);
            if (p % k != 0) {
                res++;
            }

            if (res > h) {
                return false;
            }
        }

        return res <= h;
    }
}

/*
 piles = [1, 4, 3, 2], h = 9

 how to use binary search to get min speed (number of bananas per hour)

 max (k) = Math.max(max, piles[i]); 4, 9/4 = 2
*/