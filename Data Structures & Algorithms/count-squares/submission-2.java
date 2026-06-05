class CountSquares {
    record Point(int x, int y) {}
    Map<Point, Integer> map = new HashMap<>();
    List<Point> points = new ArrayList<>();

    public CountSquares() {
        
    }
    
    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);
        map.put(p, map.getOrDefault(p, 0) + 1);
        points.add(p);
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];

        int count = 0;

        for (Point p : points) {
            int px = p.x, py = p.y;
            if (px == x || py == y || (Math.abs(px-x) != Math.abs(py-y))) continue;

            count += map.getOrDefault(new Point(px, y), 0) * map.getOrDefault(new Point(x, py), 0);
        }

        return count;
    }
}
