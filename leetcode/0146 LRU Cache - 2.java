class LRUCache {
    private int current;
    private int capacity;
    private LinkedList<Integer> l;
    private HashMap<Integer, Integer> m;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        m = new HashMap<>();
        l = new LinkedList<>();
    }
    
    public int get(int key) {
        if (null == m.get(key)) {
            return -1;
        } else {
            l.remove((Integer) key);
            l.add(key);
            return m.get(key);
        }
    }
    
    public void put(int key, int value) {
        if (current == capacity) {
            if (null == m.get(key)) {
                m.remove(l.remove());
            } else {
                l.remove((Integer) key);
            }
        } else {
            if (null == m.get(key)) {
                ++current;
            } else {
                l.remove((Integer) key);
            }
        }
        l.add(key);
        m.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */