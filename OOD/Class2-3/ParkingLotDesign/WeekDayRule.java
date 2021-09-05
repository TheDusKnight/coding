package Class3.ParkingLotDesign;

/**
 * Created by FLK on 2020-06-27.
 */
public class WeekDayRule implements IParkingRule {
    @Override
    public boolean isValid(Vehicle vehicle) {

        // ONly valid for Weekdays
        return false;
    }
}
