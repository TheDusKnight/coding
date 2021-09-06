public class InternalButton extends Button {

    private final Elevator elevator;

    public InternalButton(long id, Status status, int levelNumber, Elevator elevator) {
        super(id, status, levelNumber);
        //TODO Auto-generated constructor stub
        this.elevator = elevator;
    }
    
    public Elevator getElevator() {
        return elevator;
    }

    public boolean sendRequest() {
        elevator.handleInternalRequest(new Request(levelNumber));
        return true;
    }
}
