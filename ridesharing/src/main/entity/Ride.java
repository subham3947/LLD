package main.entity;

public class Ride {

    int id;

    
    Vehicle vehicle;
    String origin;
    String destination;
    int availableSeats;
    String driverName;

    public Ride() {
    }

    public Ride(Vehicle vehicle, String origin, String destination, int availableSeats) {
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Ride vehicle(Vehicle vehicle) {
        setVehicle(vehicle);
        return this;
    }

    public Ride origin(String origin) {
        setOrigin(origin);
        return this;
    }

    public Ride destination(String destination) {
        setDestination(destination);
        return this;
    }

    public Ride availableSeats(int availableSeats) {
        setAvailableSeats(availableSeats);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " vehicle='" + getVehicle() + "'" +
                ", origin='" + getOrigin() + "'" +
                ", destination='" + getDestination() + "'" +
                ", availableSeats='" + getAvailableSeats() + "'" +
                "}";
    }

    
}
