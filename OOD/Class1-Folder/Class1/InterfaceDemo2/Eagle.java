package Class1.InterfaceDemo2;

/**
 * Created by FLK on 2019-12-21.
 */
public class Eagle extends Bird {

    public static final String TAG = Eagle.class.getSimpleName();

    public Eagle(final String id, final int size) {
        super(id,size);
    }

    @Override
    public void fly() {
        System.out.println(String.format("%s fly fast",TAG));
    }
}
