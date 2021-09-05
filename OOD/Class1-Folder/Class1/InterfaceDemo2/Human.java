package Class1.InterfaceDemo2;

/**
 * Created by FLK on 2019-12-21.
 */
public class Human implements Swimmable {
    public static final String TAG = Human.class.getSimpleName();

    @Override
    public void swim() {
        System.out.println(String.format("%s : I can swim",TAG));
    }
}
