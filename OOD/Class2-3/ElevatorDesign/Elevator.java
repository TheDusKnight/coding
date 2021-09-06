package Class2.ElevatorDesign;

import static Class2.ElevatorDesign.Direction.STOP;
import static Class2.ElevatorDesign.ElevatorSystem.MAX_FLOOR;
import static java.awt.Event.DOWN;
import static java.awt.Event.UP;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Elevator {

    private final String id;

    private final int capacity;

    private Direction currentDirection;

    private int currentLevelNumber;

    /**
     *    1 --> 5 --> 3 --> 6 --> 4
     *
     *    1.  Queue - FIFO
     *    2.  1 --> 5 --> 6 --> 4 --> 3
     *    Up: minHeap
     *    Down: maxHeap
     */

    private final PriorityQueue<Integer> upTasks;
    private final PriorityQueue<Integer> downTasks;

    private final List<InternalButton> internalButtons;


    public Elevator(final String id, final int capacity){
        this.id = id;
        this.capacity = capacity;

        internalButtons = new ArrayList<>();

        upTasks = new PriorityQueue<>((r1, r2) -> {
           if(r1.equals(r2)) return 0;

           return r1 > r2 ? 1 : -1;
        });

        downTasks = new PriorityQueue<>((r1, r2) -> {
            if(r1.equals(r2)) return 0;

            return r2 > r1 ? 1 : -1;
        });

        initInternalButtons();
    }

    private void initInternalButtons() {
        for (int i = 1; i <= MAX_FLOOR; i++) {
            internalButtons.add(new InternalButton(id + "-" + i, i, this));
        }
    }

    // 核心
    public boolean handleInternalRequest(final Request request) {
        //Check Edge case
        if (!checkVaildRequest(request)) return false;

        // Compare the request with current Level, if larger -> up request, else down Request
        final int requestLevelNumber = request.getLevelNumber();

        //Handle the task according to the current level
        if(requestLevelNumber > currentLevelNumber && currentLevelNumber != DOWN) {
            upTasks.offer(requestLevelNumber);
            return true;
        } else if(requestLevelNumber < currentLevelNumber && currentLevelNumber != UP) {
            downTasks.offer(requestLevelNumber);
            return true;
        }

        return false;
    }


    /**
     *  Try {
     *
     *      elevator.handleExternalRequest(request);
     *
     *  } catch (InvalidRequestException e){
     *
     *      //Do something specific to this exception;
     *  }
     *
     *
     * @param externalRequest
     * @throws InvalidRequestException
     */
    // 核心
    public void handleExternalRequest (final ExternalRequest externalRequest) throws InvalidRequestException {
        if(!checkVaildRequest(externalRequest)) return;

        final int requestLevelNumber = externalRequest.getLevelNumber();

        if(externalRequest.getDirection() == Direction.UP) {
            if(externalRequest.getLevelNumber() > currentLevelNumber && currentDirection != Direction.DOWN ) {
                upTasks.offer(requestLevelNumber);
            } else {
                throw new InvalidRequestException("This Up Request is Invalid");
            }
        } else if(externalRequest.getDirection() == Direction.DOWN) {
            if(externalRequest.getLevelNumber() < currentLevelNumber && currentLevelNumber != UP) {
                downTasks.offer(requestLevelNumber);
            } else {
                throw new InvalidRequestException("This Down Request is Invalid");
            }
        }
    }

    private boolean checkVaildRequest(Request request) {
        if (request == null) return false;

        final Integer requestLevelNumber = request.getLevelNumber();

        if(requestLevelNumber < 1 || requestLevelNumber > MAX_FLOOR){
            //Edge cases

            Log.info("Elevator: The request is invalid");
            return false;
        } else if (requestLevelNumber == currentLevelNumber
                || upTasks.contains(requestLevelNumber)
                || downTasks.contains(requestLevelNumber)) {
            //Duplicate cases
            Log.info("Elevator: The request is duplicate");
            return false;
        }

        return true;
    }

    //Elevator Move Up
    public void moveUp(){
        currentDirection = Direction.UP;

        while(!upTasks.isEmpty()){
            currentLevelNumber = upTasks.poll();
        }

        currentDirection = STOP;
    }

    //Elevator Move down
    public void moveDown(){
        currentDirection = Direction.DOWN;
        while(!downTasks.isEmpty()){
            currentLevelNumber = downTasks.poll();
        }

        currentDirection = STOP;
    }

    public void run(){
        if(currentDirection == STOP){
            while (!upTasks.isEmpty()) {
                moveUp();
            }

            while(!downTasks.isEmpty()){
                moveDown();
            }
        }
    }
}
