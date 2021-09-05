package Class3.ObserverDesignPattern;

/**
 * Created by FLK on 2021-05-01.
 */
public class ObserverA implements IStateObserver {
    @Override
    public void onStateChange(int state) {
        System.out.println("State A change received: " + state * 2);
    }
}
