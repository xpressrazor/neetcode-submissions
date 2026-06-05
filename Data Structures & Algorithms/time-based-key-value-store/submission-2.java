class TimeMap {
    static class Data {
        String val;
        int time;

        public Data(int time, String value) {
            this.val = value;
            this.time = time;
        }
    }

    public TimeMap() {
        
    }
    
    Map<String, List<Data>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x -> new ArrayList<>()).add(new Data(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Data> list = map.getOrDefault(key, new ArrayList<>());

        int hi = timestamp, lo = 0;
        String res = "";


        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (list.size() > mid && list.get(mid).time <= timestamp) {
                lo = mid + 1;
                res = list.get(mid).val;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }
}
