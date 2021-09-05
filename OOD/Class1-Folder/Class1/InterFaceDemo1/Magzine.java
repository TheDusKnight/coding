package Class1.InterFaceDemo1;

/**
 * Created by FLK on 2020-06-13.
 */
public class Magzine implements IReadable{

    @Override
    public String getContent() {
        return "this is a Magzine";
    }
}
