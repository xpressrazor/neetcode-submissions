class Solution {
    /*
        O((n+m)logk), n, m inervals, queries size, k is unique points
        O(k)

        1. Map unique points to their sorted index in a map
        2. Update segment tree with intervals width using above map's width (uses minimum value at any range)
        3. For query get the sorted index and get value from segment tree
    */

    static final int INF = Integer.MAX_VALUE / 4;

    static class SegmentTree {
        private int[] tree, lazy;
        int n;

        public SegmentTree(int N) {
            this.n = N;
            tree = new int[4 * N];
            lazy = new int[4 * N];

            Arrays.fill(tree, INF);
            Arrays.fill(lazy, INF);
        }

        private void propagate(int treeIndex, int arrStart, int arrEnd) {
            if (lazy[treeIndex] != INF) {
                tree[treeIndex] = Math.min(tree[treeIndex], lazy[treeIndex]);

                if (arrStart != arrEnd) {
                    lazy[2 * treeIndex + 1] = Math.min(lazy[2 * treeIndex + 1], lazy[treeIndex]);
                    lazy[2 * treeIndex + 2] = Math.min(lazy[2 * treeIndex + 2], lazy[treeIndex]);
                }

                lazy[treeIndex] = INF;
            }
        }

        public int query(int index) {
            return query(0, 0, n-1, index);
        }

        public void update(int updateStart, int updateEnd, int val) {
            update(0, 0, n-1, updateStart, updateEnd, val);
        }

        private int query(int treeIndex, int arrStart, int arrEnd, int index) {
            propagate(treeIndex, arrStart, arrEnd);

            if (arrStart > arrEnd) {
                return INF;
            }

            if (arrStart == arrEnd) {
                return tree[treeIndex];
            }

            int mid = arrStart + ((arrEnd - arrStart) >> 1);

            if (index <= mid) {
                return query(2 * treeIndex + 1, arrStart, mid, index);
            } else {
                return query(2 * treeIndex + 2, mid + 1, arrEnd, index);
            }
        }

        private void update(int treeIndex, int arrStart, int arrEnd, int updateStart, int updateEnd, int val) {
            propagate(treeIndex, arrStart, arrEnd);

            if (arrStart > arrEnd || arrStart > updateEnd || updateStart > arrEnd) {
                return;
            }

            if (updateStart <= arrStart && arrEnd <= updateEnd) {
                lazy[treeIndex] = Math.min(lazy[treeIndex], val);
                propagate(treeIndex, arrStart, arrEnd);
                return;
            }

            int mid = arrStart + ((arrEnd - arrStart) >> 1);

            update(2 * treeIndex + 1, arrStart, mid, updateStart, updateEnd, val);
            update(2 * treeIndex + 2, mid + 1, arrEnd, updateStart, updateEnd, val);
            tree[treeIndex] = Math.min(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
        }
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        List<Integer> points = new ArrayList<>();
        
        for (int[] interval : intervals) {
            points.add(interval[0]);
            points.add(interval[1]);
        }

        for (int q : queries) {
            points.add(q);
        }

        List<Integer> uniquePoints = new ArrayList<>(new HashSet<>(points));
        Collections.sort(uniquePoints);

        Map<Integer, Integer> compressMap = new HashMap<>();

        int n = uniquePoints.size();
        for (int i = 0; i < n; i++) {
            compressMap.put(uniquePoints.get(i), i);
        }

        SegmentTree segmentTree = new SegmentTree(uniquePoints.size());

        for (int[] interval : intervals) {
            segmentTree.update(compressMap.get(interval[0]), compressMap.get(interval[1]), interval[1] - interval[0] + 1);
        }

        int m = queries.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int val = segmentTree.query(compressMap.get(queries[i]));
            result[i] = val == INF ? -1 : val;
        }

        return result;
    }
}
