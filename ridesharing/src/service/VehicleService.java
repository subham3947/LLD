package service;


import main.entity.Vehicle;

public interface VehicleService {

    public void registerVehicle(Vehicle vehicle);

    public Vehicle getRgisteredVehicle(String ownerName,  String vehicleIdentificationNumber);
    
}
