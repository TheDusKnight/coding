package OOD.DecoratorPattern;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer peek;

    public PeekingIterator(Iterator<Integer> iter, Integer peek) {
        this.iter = iter;
        this.peek = null; // peek means the next value in iter
    }

    public Integer peek() {
        if (peek != null) return peek;

        peek = iter.next();
        return peek;
    }

    @Override
    public boolean hasNext() {
        if (peek != null) return true;

        return iter.hasNext();
    }

    @Override
    public Integer next() {
        if (peek != null) {
            Integer tmp = peek;
            peek = null;
            return tmp;
        }

        return iter.next();
    }
}
