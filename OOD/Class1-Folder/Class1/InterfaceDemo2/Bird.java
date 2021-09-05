package Class1.InterfaceDemo2;

/**
 * Created by FLK on 2019-12-21.
 */
public abstract class Bird{
    final String id;
    final int size;

    public Bird(final String id, final int size){
        this.id = id;
        this.size = size;
    }

    public abstract void fly();
}
