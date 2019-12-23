class LRUCache extends LinkedHashMap {
    private int capa;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capa;
    }

    public LRUCache(int capacity) {
        super(capacity, (float) 0.75, true);
        capa = capacity;
    }

    public int get(int key) {
        if (!containsKey(key)) return -1;
        return (int) super.get(key);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */