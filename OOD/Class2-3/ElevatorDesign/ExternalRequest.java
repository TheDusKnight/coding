package Class2.ElevatorDesign;

/**
 * Created by FLK on 2020-06-20.
 */
public class ExternalRequest extends Request {

    private final Direction direction;

    public ExternalRequest(final int levelNumber, final Direction direction) {
        super(levelNumber);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
