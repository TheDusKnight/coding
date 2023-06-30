package OOD.SingletonPattern;

public final class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public Singleton getSingleton() {
        if (singleton == null) { // improve performance
            synchronized (Singleton.class) {
                if (singleton == null) { // check correctness
                    return new Singleton();
                }
            }
        }

        return null;
    }
}
