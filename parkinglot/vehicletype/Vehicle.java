package vehicletype;

public abstract class Vehicle {
    protected String license;
    protected VehicleType type;

    public Vehicle(String license, VehicleType type) {
        this.license = license;
        this.type = type;
    }

    // gettters for getting vehicle type;

    public VehicleType getType() {
        return type;
    }

}
