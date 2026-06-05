class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;
        int lo = 0, hi = n1;

        while (lo <= hi) {
            var m1 = lo + ((hi - lo) >> 1);
            var m2 = (n + 1) / 2 - m1;

            var l1 = m1 == 0 ? Integer.MIN_VALUE : nums1[m1-1];
            var r1 = m1 == n1 ? Integer.MAX_VALUE : nums1[m1];
            var l2 = m2 == 0 ? Integer.MIN_VALUE : nums2[m2-1];
            var r2 = m2 == n2 ? Integer.MAX_VALUE : nums2[m2];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                hi = m1 - 1;
            } else {
                lo = m1 + 1;
            }
        }

        return -1.0;
    }
}
