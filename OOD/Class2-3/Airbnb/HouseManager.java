package Class3.Airbnb;

import Class3.Airbnb.GeoLocation.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FLK on 2020-01-01.
 */
public class HouseManager {

    private static HouseManager instance = null;

    public static HouseManager getInstance(){
        if(instance == null) {
            instance = new HouseManager();
        }

        return instance;
    }

    public List<House> searchByAddress(final Address address) {
        //Do some query operation or service call
        return new ArrayList<>();
    }

    public List<House> searchByZipcode(final int zipcode) {
        //Do some query operation or service call
        return new ArrayList<>();
    }
}
