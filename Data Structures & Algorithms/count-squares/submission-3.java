class CountSquares {
    record Point(int x, int y) {}
    Map<List<Integer>, Integer> map = new HashMap<>();
    List<List<Integer>> points = new ArrayList<>();

    public CountSquares() {
        
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        map.put(p, map.getOrDefault(p, 0) + 1);
        points.add(p);
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];

        int count = 0;

        for (List<Integer> p : points) {
            int px = p.get(0), py = p.get(1);
            if (px == x || py == y || (Math.abs(px-x) != Math.abs(py-y))) continue;

            count += map.getOrDefault(Arrays.asList(px, y), 0) * map.getOrDefault(Arrays.asList(x, py), 0);
        }

        return count;
    }
}
