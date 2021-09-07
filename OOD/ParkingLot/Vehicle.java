public abstract class Vehicle {
    protected final long id;
    protected Type type;

    public Vehicle(long id, Type type) {
        this.id = id;
        this.type = type;
    }
    
    public long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }
}
