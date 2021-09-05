package Class3.ParkingLotDesign;

import java.util.List;

public class ParkingLevel {

    private final int motorNum;
    private final int compactNum;
    private final int busNum;
    private final int size;
    private final String id;

    private final ParkingGarage parkingGarage;
    private final ParkingSpot[] motorSpots;
    private final ParkingSpot[] compactSpots;
    private final ParkingSpot[] busSpots;

    private int emptyMoto;
    private int emptyCompact;
    private int emptyBus;

    private IParkingRule parkingRule;

    private List<IParkingRule> parkingRules;

    public ParkingLevel(final String id, final int motoNum, final int compactNum, final int busNum, final ParkingGarage parkingGarage){
        this.id = id;
        this.motorNum = motoNum;
        this.compactNum = compactNum;
        this.busNum = busNum;
        size = motoNum + compactNum + busNum;
        emptyMoto = motoNum;
        emptyCompact = compactNum;
        emptyBus = busNum;

        this.parkingGarage = parkingGarage;
        motorSpots = new ParkingSpot[motoNum];
        compactSpots = new ParkingSpot[compactNum];
        busSpots = new ParkingSpot[busNum];

        for(int i = 0; i < size; i++){
            if (i < motoNum) {
                motorSpots[i] = new ParkingSpot(id + i,VehicleType.Motor);
            } else if(i >= motoNum && i < motoNum + compactNum){
                compactSpots[i - motoNum] = new ParkingSpot(id + i,VehicleType.Compact);
            } else {
                busSpots[i - motoNum - compactNum] = new ParkingSpot(id + i, VehicleType.Bus);
            }
        }

    }

    public void setParkingRule(final IParkingRule parkingRule) {
        this.parkingRule = parkingRule;
    }

    public void addParkingRule(final IParkingRule parkingRule) {
        parkingRules.add(parkingRule);
    }

    // 1 - 5 level, any car  level >= 6, Compact, Motor, Level >= 9, Motor


    public boolean canPark(Vehicle vehicle) {

        for(IParkingRule parkingRule : parkingRules) {
            if(!parkingRule.isValid(vehicle)) return false;
        }

        if(vehicle instanceof MotorCycle){
            return emptyMoto > 0;
        } else if (vehicle instanceof Compact){
            return emptyCompact > 0;
        }  else {
            return emptyBus > 0;
        }
    }

    public int getEmptySpotNum() {
        return emptyBus + emptyMoto + emptyCompact;
    }

    public int getSize() {
        return size;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(!canPark(vehicle)) return false;

        if(vehicle instanceof MotorCycle){
            park(vehicle, motorSpots);
            emptyMoto--;
        } else if (vehicle instanceof Compact){
            park(vehicle,compactSpots);
            emptyCompact--;
        } else {
            park(vehicle,busSpots);
            emptyBus--;
        }

        return true;
    }

    private void park(Vehicle vehicle, ParkingSpot[] parkingSpots){
        for (ParkingSpot parkingSpot : parkingSpots){
            if(parkingSpot.isEmpty()){
                parkingSpot.vehiclePark(vehicle);
            }
        }
    }

    public void vehicleLeavePark(Vehicle vehicle){
        if(vehicle.getType() == VehicleType.Motor){
            emptyMoto++;
        } else if(vehicle.getType() == VehicleType.Compact){
            emptyCompact++;
        } else {
            emptyBus++;
        }
        parkingGarage.vehicleLeavePark();
    }





}
