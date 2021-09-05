package Class3.ParkingLotDesign;


public abstract class Vehicle {

    private Ticket ticket;

    protected final VehicleType type;
    protected final String id;
    protected ParkingSpot parkedSpot;

    public Vehicle (final String id, final VehicleType type){
        this.type = type;
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void addTicket(final Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public  void setSpot(final ParkingSpot parkingSpot) {
        parkedSpot = parkingSpot;
    }
}
