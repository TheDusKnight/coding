package Class1.InterFaceDemo1;

/**
 * Created by FLK on 2020-06-13.
 */
public class NewsPaper implements IReadable{

    @Override
    public String getContent(){

        return "This is a NewsPaper";
    }
}
