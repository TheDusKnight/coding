package leetcode;

public class Pair<K, V> {

    private final K element0;
    private final V element1;

    public static <T, U> Pair<T, U> createPair(T element0, U element1) {
        return new Pair<T, U>(element0, element1);
    }

    public Pair(K element0, V element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public K getKey() {
        return element0;
    }

    public V getValue() {
        return element1;
    }

}
