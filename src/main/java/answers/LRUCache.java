package answers;

// TODO
public class LRUCache {

    LRUCache(int capacity) {

    }

    public int get(int key) {
        return -1;
    }

    public void put(int key, int value)  {

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assert cache.get(1) == 1;
        cache.put(3, 3);
        assert cache.get(2) == -1;
        cache.put(4, 4);
        assert cache.get(1) == -1;
        assert cache.get(3) == 3;
        assert cache.get(4) == 4;
    }
}
