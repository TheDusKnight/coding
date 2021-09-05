package Class3.ParkingLotDesign;

/**
 * Created by FLK on 2020-06-27.
 */
public class TechbowStudentRule implements IParkingRule {
    @Override
    public boolean isValid(Vehicle vehicle) {

        //Only valid for Techbow Student

        return false;
    }
}
