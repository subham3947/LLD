package service;

import dao.RideSharingDao;
import exception.UserNotFoundException;
import exception.VehicleAlreadyRegistered;
import main.entity.Vehicle;

public class VehicleServiceImpl implements VehicleService {

    RideSharingDao rideSharingDao;
    public VehicleServiceImpl() {
        rideSharingDao = RideSharingDao.getInstance();
    }

    @Override
    public void registerVehicle(Vehicle vehicle){
        
        rideSharingDao.registerVehicle(vehicle);
    }

    @Override
    public Vehicle getRgisteredVehicle(String ownerName, String vehicleIdentificationNumber) {
        
       return rideSharingDao.getVehicleDetails(ownerName+"_"+vehicleIdentificationNumber);
    }
    
}
