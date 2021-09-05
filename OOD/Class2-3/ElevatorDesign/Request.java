package Class2.ElevatorDesign;

/**
 * Created by FLK on 2020-06-20.
 */
public class Request {
    protected final int levelNumber;

    public Request(final int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
