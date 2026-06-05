class Solution {
    static class SegmentTree {
        int n;
        int[] tree;
        
        public SegmentTree(int N) {
            n = N;

            while ((n & (n - 1)) != 0) {
                n++;
            }

            tree = new int[2 * n];
        }

        public void update(int i, int val) {
            tree[n + i] = val;
            int j = (n + i) >> 1;

            while (j >= 1) {
                tree[j] = Math.max(tree[j << 1], tree[j << 1 | 1]);
                j >>= 1;
            }
        }

        int query(int l, int r) {
            if (l > r) {
                return 0;
            }

            int res = Integer.MIN_VALUE;
            l += n;
            r += n + 1;
            
            while (l < r) {
                if ((l & 1) != 0) {
                    res = Math.max(res, tree[l]);
                    l++;
                }

                if ((r & 1) != 0) {
                    r--;
                    res = Math.max(res, tree[r]);
                }

                l >>= 1;
                r >>= 1;
            }

            return res;
        }
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] sortedArray = Arrays.stream(nums).distinct().sorted().toArray();
        int[] order = new int[n];

        for (int i = 0; i < n; i++) {
            order[i] = Arrays.binarySearch(sortedArray, nums[i]);
        }

        SegmentTree segmentTree = new SegmentTree(sortedArray.length);
        int lis = 0;

        for (int num : order) {
            int curlis = segmentTree.query(0, num - 1) + 1;
            segmentTree.update(num, curlis);
            lis = Math.max(lis, curlis);
        }

        return lis;
    }
}
