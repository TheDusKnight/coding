package Class3.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FLK on 2021-05-01.
 */
public class StateChangeObservable {

    private List<IStateObserver> stateObservers = new ArrayList<>();

    private int state;

    public StateChangeObservable(){
        state = 0;
    }

    public void setState(int state){
        if(this.state != state) {
            this.state = state;
            notifyListener(state);
        }
    }

    private void notifyListener(int state){
        for(IStateObserver observer : stateObservers){
            observer.onStateChange(state);
        }
    }

    public void registerListener(IStateObserver stateObserver){
        stateObservers.add(stateObserver);
    }

    public void unregisterListener(IStateObserver stateObserver){
        stateObservers.remove(stateObserver);
    }
}
