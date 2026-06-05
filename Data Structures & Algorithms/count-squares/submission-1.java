class CountSquares {
    private Map<List<Integer>, Integer> pointsFreqMap = new HashMap<>();
    private List<List<Integer>> points = new ArrayList<>();

    public CountSquares() {
        
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        points.add(p);
        pointsFreqMap.put(p, pointsFreqMap.getOrDefault(p, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];

        for (List<Integer> pt : points) {
            int x = pt.get(0), y = pt.get(1);

            // not a square
            if (Math.abs(px - x) != Math.abs(py - y) || x == px || y == py) {
                continue;
            }

            res += pointsFreqMap.getOrDefault(Arrays.asList(x, py), 0) 
                * pointsFreqMap.getOrDefault(Arrays.asList(px, y), 0);
        }

        return res;
    }
}
