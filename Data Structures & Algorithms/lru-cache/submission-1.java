class LRUCache {
    
    private static class Node {
        Node prev, next;
        int key, val;

        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // promote to front
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;

            remove(node);
            add(node);
        } else {
            Node node = new Node(key, value);
            add(node);

            if (map.size() > capacity) {
                remove(tail.prev);
            }
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
    }

    private void add(Node node) {
        Node prev = head;
        Node next = head.next;
        prev.next = node;
        node.prev = prev;
        next.prev = node;
        node.next = next;
        map.put(node.key, node);
    }
}
