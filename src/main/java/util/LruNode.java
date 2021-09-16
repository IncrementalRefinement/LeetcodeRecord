package util;

public class LruNode<KeyType, ValueType> {
    private LruNode<KeyType, ValueType> prev, next;
    private KeyType key;
    private ValueType value;

    public LruNode<KeyType, ValueType> getPrev() {
        return prev;
    }

    public void setPrev(LruNode<KeyType, ValueType> prev) {
        this.prev = prev;
    }

    public LruNode<KeyType, ValueType> getNext() {
        return next;
    }

    public void setNext(LruNode<KeyType, ValueType> next) {
        this.next = next;
    }

    public KeyType getKey() {
        return key;
    }

    public void setKey(KeyType key) {
        this.key = key;
    }

    public ValueType getValue() {
        return value;
    }

    public void setValue(ValueType value) {
        this.value = value;
    }
}
