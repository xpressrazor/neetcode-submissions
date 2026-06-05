class ListNode {
    ListNode next;
    int val;

    public ListNode(int v) {
        val = v;
    }
}

class MyHashSet {
    static final int SIZE = 10000;
    ListNode[] bucket = new ListNode[SIZE];

    public MyHashSet() {
        for (int i = 0; i < SIZE; ++i) {
            bucket[i] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        int h = getHash(key);
        if (bucket[h] == null) bucket[h] = new ListNode(key);
        else {
            ListNode cur = bucket[h];
            while (cur.next != null) {
                if (cur.next.val == key) return;
                cur = cur.next;
            }
            cur.next = new ListNode(key);
        }
    }
    
    public void remove(int key) {
        int h = getHash(key);
        if (bucket[h] == null) return;
        ListNode cur = bucket[h];
        while (cur.next != null) {
            if (cur.next.val == key) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
    }
    
    public boolean contains(int key) {
        int h = getHash(key);
        ListNode cur = bucket[h];
        
        while (cur.next != null) {
            if (cur.next.val == key) return true;
            cur = cur.next;
        }

        return false;
    }

    private int getHash(int v) {
        return v % SIZE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */