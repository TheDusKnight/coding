package Class1.InterfaceDemo2;

/**
 * Created by FLK on 2019-12-21.
 */
public class Sparrow extends Bird {
    public static final String TAG = Sparrow.class.getSimpleName();

    public Sparrow(String id, int size) {
        super(id, size);
    }

    @Override
    public void fly() {
        System.out.println(String.format("%s fly slow",TAG));
    }
}
