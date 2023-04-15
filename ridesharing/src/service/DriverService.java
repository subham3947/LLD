package service;

import main.entity.Driver;
import main.entity.Ride;

public interface DriverService {

    public void registerDriver(Driver driver);

    public void offerRide(Ride ride);

    public void endRide();
    
}
