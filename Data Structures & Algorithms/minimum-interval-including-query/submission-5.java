class Solution {

    static class SegmentTree {
        int n;
        int[] tree;
        int[] lazy;

        public SegmentTree(int N) {
            this.n = N;
            tree = new int[4 * N];
            lazy = new int[4 * N];
            Arrays.fill(tree, Integer.MAX_VALUE);
            Arrays.fill(lazy, Integer.MAX_VALUE);
        }

        public void update(int updateStart, int updateEnd, int val) {
            update(0, 0, n-1, updateStart, updateEnd, val);
        }

        public int query(int index) {
            return query(0, 0, n-1, index);
        }

        private void propagate(int treeIndex, int arrayStart, int arrayEnd) {
            if (lazy[treeIndex] != Integer.MAX_VALUE) {
                
                tree[treeIndex] = Math.min(tree[treeIndex], lazy[treeIndex]);

                if (arrayStart != arrayEnd) {
                    lazy[2 * treeIndex + 1] = Math.min(lazy[2 * treeIndex + 1], lazy[treeIndex]);
                    lazy[2 * treeIndex + 2] = Math.min(lazy[2 * treeIndex + 2], lazy[treeIndex]);
                }

                lazy[treeIndex] = Integer.MAX_VALUE;
            }
        }

        // range update
        private void update(int treeIndex, int arrayStart, int arrayEnd, int updateStart, int updateEnd, int val) {
            propagate(treeIndex, arrayStart, arrayEnd);

            if (arrayStart > arrayEnd || arrayStart > updateEnd || updateStart > arrayEnd) {
                return;
            }

            if (updateStart <= arrayStart && arrayEnd <= updateEnd) {
                lazy[treeIndex] = Math.min(lazy[treeIndex], val);
                propagate(treeIndex, arrayStart, arrayEnd);
                return;
            }

            int mid = (arrayStart + arrayEnd) / 2;
            update(treeIndex * 2 + 1, arrayStart, mid, updateStart, updateEnd, val);
            update(treeIndex * 2 + 2, mid + 1, arrayEnd, updateStart, updateEnd, val);
            tree[treeIndex] = Math.min(tree[treeIndex * 2 + 1], tree[treeIndex * 2 + 2]);
        }

        // point query
        private int query(int treeIndex, int arrayStart, int arrayEnd, int index) {
            propagate(treeIndex, arrayStart, arrayEnd);
            
            if (arrayStart == arrayEnd) {
                return tree[treeIndex];
            }

            int mid = (arrayStart + arrayEnd) / 2;

            if (index <= mid) {
                return query(treeIndex * 2 + 1, arrayStart, mid, index);
            } else {
                return query(treeIndex * 2 + 2, mid + 1, arrayEnd, index);
            }
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

        // unique point list (sorted)
        points = new ArrayList<>(new HashSet<>(points));
        Collections.sort(points);

        // Compress the points to indices
        Map<Integer, Integer> compress = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            compress.put(points.get(i), i);
        }

        // Create segment tree
        SegmentTree segmentTree = new SegmentTree(points.size());

        // Update the segment tree with intervals
        for (int[] interval : intervals) {
            int start = compress.get(interval[0]);
            int end = compress.get(interval[1]);
            int length = interval[1] - interval[0] + 1;
            segmentTree.update(start, end, length);
        }

        // Query the segment tree for each query
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = compress.get(queries[i]);
            int val = segmentTree.query(index);
            result[i] = val == Integer.MAX_VALUE ? -1 : val;
        }

        return result;
    }
}
