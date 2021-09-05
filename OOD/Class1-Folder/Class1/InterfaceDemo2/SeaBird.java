package Class1.InterfaceDemo2;

/**
 * Created by FLK on 2019-12-21.
 */
public class SeaBird extends Bird implements Swimmable, IJumpable {
    public static final String TAG = SeaBird.class.getSimpleName();

    public SeaBird(String id, int size) {
        super(id, size);
    }

    @Override
    public void fly() {
        System.out.println(String.format("%s fly above Sea",TAG));
    }

    @Override
    public void swim() {
        System.out.println(String.format("%s can swim to catch fish",TAG));
    }

    @Override
    public void jump(){
        System.out.println("SeaBird can Jump");
    }
}
