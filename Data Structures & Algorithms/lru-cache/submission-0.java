class LRUCache {

    static class Node {
        Node next, prev;

        int key, val;

        public Node (int k, int v) {
            key = k;
            val = v;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addNode(Node node) {
        Node prev = head;
        Node next = head.next;
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }

    Map<Integer, Node> map = new HashMap<>();
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        addNode(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            map.remove(key);
        }

        if (map.size() == capacity) {
            Node lastNode = tail.prev;
            removeNode(lastNode);
            map.remove(lastNode.key);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}
