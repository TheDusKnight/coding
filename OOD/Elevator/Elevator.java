import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {
    private final long id;
    private final int capacity;
    private int curLevel;
    private Status direction;
    Queue<Integer> upTask;
    Queue<Integer> downTask;
    List<Integer> list;
     
    
    public Elevator(long id, int capacity, int curLevel, Status direction) {
        this.id = id;
        this.capacity = capacity;
        this.curLevel = curLevel;
        this.direction = direction;
        upTask = new PriorityQueue<>((r1, r2) -> (r1 - r2));
        downTask = new PriorityQueue<>((r1, r2) -> (r2 - r1));
        list = new ArrayList<>();
        init();
    }

    private void init() {
        for (int i = 0; i < capacity; i++) {
            list.add(new InternalButton(id, status, levelNumber, this));
        }
    }

    public boolean handleInternalRequest(Request request) {
        if (request == null) return false;
        
        int requestLevelNumber = request.getLevelNumer();
        if (curLevel < requestLevelNumber && direction == UP) {
            upTask.add(requestLevelNumber);
            return true;
        } else if (curLevel > requestLevelNumber && direction == DOWN) {
            downTask.add(requestLevelNumber);
            return true;
        }
        return false;

    }

    public getElevatorId() {
        return id; 
    }

    public boolean handleExternalRequest(ExternalRequest externalRequest) {
        if (externalRequest == null) return false;

        int requestLevelNumber = externalRequest.getLevelNumber();
        if (externalRequest.getDirection() == UP) {
            if (curLevel < requestLevelNumber && direction != DOWN) {
                upTask.add(requestLevelNumber);

            } else {
                throw new IllegalArgumentException();
            }
        } else if (externalRequest.getDirection() == DOWN) {
            if (curLevel > requestLevelNumber && direction != UP) {
                downTask.add(requestLevelNumber);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public boolean checkVaildRequest(Request request) {
        if (request == null) return false;
        int levelNumber = request.getLevelNumber();
        if (levelNumber < 1 || levelNumber > MAX_CAPACITY) return false;

        
    }
}
