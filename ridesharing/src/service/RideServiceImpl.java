package service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparator.MostVacantSeatsComparator;
import dao.RideSharingDao;
import main.entity.Driver;
import main.entity.Ride;
import main.entity.User;

public class RideServiceImpl implements RideService{

    static int rideId = 0;
    RideSharingDao rideSharingDao;

    public RideServiceImpl() {
        rideSharingDao = RideSharingDao.getInstance();
    }

    @Override
    public void storeRideDetails(Ride ride) {
        rideId++;
        ride.setId(rideId);
        rideSharingDao.offerRide(ride, rideId);
    }

    @Override
    public boolean rideAvailable(String passengerName, String origin, String destination, int requestedSeats, String criteria) {
        // "Most Vacant”
        // "Preferred Vehicle=Activa”
        boolean isRideAvailable = false;
        Ride availableRide = null;
        if(enums.SelectionStrategy.MOST_VACANT.name().contentEquals(criteria)){
            List<Ride> rides = rideSharingDao.getAllRides();
            Collections.sort(rides, new MostVacantSeatsComparator());

            for(Ride ride : rides)
                if(ride.getOrigin().equalsIgnoreCase(origin) && ride.getDestination().equalsIgnoreCase(destination) &&
                    ride.getAvailableSeats() >= requestedSeats){
                        availableRide= ride;
                        isRideAvailable = true;
                        break;
                    }
                        
        }else{
            String[] preferredVehicle = criteria.split("=");
            List<Ride> rides= rideSharingDao.getAllRidesWithTheSameCarName(preferredVehicle[1]);

            for(Ride ride : rides)
                if(ride.getOrigin().equalsIgnoreCase(origin) && ride.getDestination().equalsIgnoreCase(destination) &&
                    ride.getAvailableSeats() >= requestedSeats){
                        availableRide= ride;
                        isRideAvailable =  true;
                        break;
                    }
                        
        }
        if(isRideAvailable){
            rideSharingDao.updateOfferedRides(availableRide.getDriverName(), availableRide);
            rideSharingDao.updateTakenRides(passengerName);
            rideSharingDao.updateSeats(availableRide, requestedSeats);
            System.out.println("Ride booked successfully!");
        }
        
        return isRideAvailable;
    }

    @Override
    public Map<String, Integer[]> getRideStats() {

        Map<String, Integer[]> rideStats = new HashMap<String, Integer[]>(); // 0 -> Ride Taken 1 ->  Ride Offered
        Map<String, User> userMap = rideSharingDao.getUserMap();
        Map<String, Driver> driverMap = rideSharingDao.getDriverMap();
        
        for(String driverName : driverMap.keySet()){
            Integer[] rideTakenAndOffered = new Integer[2];
            Driver driver = driverMap.get(driverName);
            rideTakenAndOffered[0] = userMap.get(driverName).getTakenRides().size(); 
            rideTakenAndOffered[1] = driver.getOfferedRides().size();
            rideStats.put(driverName, rideTakenAndOffered);
        }   

        for(String userName : userMap.keySet()){
            Integer[] rideTakenAndOffered = new Integer[2];
            User user = userMap.get(userName);
            if(!rideStats.containsKey(userName)){
                rideTakenAndOffered[0] = userMap.get(userName).getTakenRides().size(); 
                rideTakenAndOffered[1] = 0;
                rideStats.put(userName, rideTakenAndOffered);
            }
            
        }
        return rideStats;
       
    }
    
}
