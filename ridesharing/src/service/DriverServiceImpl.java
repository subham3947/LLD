package service;

import java.util.List;

import dao.RideSharingDao;
import main.entity.Driver;
import main.entity.Ride;

public class DriverServiceImpl implements DriverService {

    RideSharingDao rideSharingDao;
    RideService rideService;

    public DriverServiceImpl() {
        rideSharingDao = RideSharingDao.getInstance();
        rideService = new RideServiceImpl();
    }
    @Override
    public void registerDriver(Driver driver) {
        // TODO Auto-generated method stub
        rideSharingDao.registerDriver(driver);
        
    }

    @Override
    public void offerRide(Ride ride) {
        boolean isRideValid = true;
        List<Ride> rides = rideSharingDao.getAllRidesWithTheSameCarName(ride.getVehicle().getVehicleModelName());
        
        for(Ride currentRide : rides){
            if(currentRide.getVehicle().getVehicleIdentificationNumber() == ride.getVehicle().getVehicleIdentificationNumber()){
                isRideValid = false;
                break;
            }
        }

        if(isRideValid)
            rideService.storeRideDetails(ride);
    }

    @Override
    public void endRide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endRide'");
    }
    
    
}
