public class ExternalRequest extends Request{
    Direction direction;

    public ExternalRequest(int levelNumber, Direction direction) {
        super(levelNumber);
        this.Direction = direction;
        //TODO Auto-generated constructor stub
    }
    
    public Direction getDirection() {
        return direction;
    }

}
