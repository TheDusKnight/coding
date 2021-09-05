package Class3.ObserverDesignPattern;

/**
 * Created by FLK on 2021-05-01.
 */
public class ObseverB implements IStateObserver {

    @Override
    public void onStateChange(int state) {
        System.out.println("State B change received: " + state * 5);
    }
}
