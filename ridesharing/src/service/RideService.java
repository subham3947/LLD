package service;

import java.util.Map;

import main.entity.Ride;

public interface RideService {
    
    public void storeRideDetails(Ride ride);

    public boolean rideAvailable(String pasengerName,String origin, String destination, int requestedSeats,String criteria);

    public Map<String, Integer[]> getRideStats();
}
