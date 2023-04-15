package main.entity;

public class Vehicle {

    
    String vehicleModelName;
    String vehicleIdentificationNumber;
    String vehicleOwner;

    public Vehicle() {
    }

    public Vehicle(String vehicleModelName, String vehicleIdentificationNumber,  String vehicleOwner) {
        this.vehicleModelName = vehicleModelName;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.vehicleOwner = vehicleOwner;
    }

    public String getVehicleModelName() {
        return this.vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public String getVehicleIdentificationNumber() {
        return this.vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public String getVehicleOwner() {
        return this.vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public Vehicle vehicleModelName(String vehicleModelName) {
        setVehicleModelName(vehicleModelName);
        return this;
    }

    public Vehicle vehicleIdentificationNumber(String vehicleIdentificationNumber) {
        setVehicleIdentificationNumber(vehicleIdentificationNumber);
        return this;
    }

    // public Vehicle availableSeats(int availableSeats) {
    //     setAvailableSeats(availableSeats);
    //     return this;
    // }

    // public Vehicle vehicleOwner(User vehicleOwner) {
    //     setVehicleOwner(vehicleOwner);
    //     return this;
    // }

    

    
}
