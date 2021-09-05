package Class1.InterFaceDemo1;

/**
 * Created by FLK on 2020-06-13.
 */
public class Book implements IReadable {

    @Override
    public String getContent() {
        return "This is a book";
    }
}
