package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import main.entity.Driver;
import main.entity.Ride;
import main.entity.User;
import main.entity.Vehicle;

public class RideSharingDao {

    static RideSharingDao rideSharingDaoInstance;
    Map<String, User> userMap;
    Map<String, Driver> driverMap;
    Map<String, Vehicle> vehicleMap;
    Map<String, List<Ride>> vehicleRidesMap; //List to be sorted in terms of vacant seats
    Map<Integer, Ride> rideMap;
    
    private RideSharingDao(){
        userMap = new HashMap<String, User>();
        vehicleMap = new HashMap<String, Vehicle>();
        driverMap = new HashMap<String, Driver>();
        vehicleRidesMap = new HashMap<>();
        rideMap = new HashMap<>();
    }

    public static RideSharingDao getInstance(){
        if(rideSharingDaoInstance == null)
            rideSharingDaoInstance = new RideSharingDao();
        return rideSharingDaoInstance;
    }

    public void addUser(User user){
        if(!userMap.containsKey(user.getName())){
            userMap.put(user.getName(), user);
            System.out.println("User registered successfully!");
        }
    }

    public User getUserDetails(String username){
        User user = null;
        if(userMap.containsKey(username))
            user = userMap.get(username);
        return user;
    }   

    public Vehicle getVehicleDetails(String vehicleModelName) {
        Vehicle vehicle = null;
        
        if(vehicleMap.containsKey(vehicleModelName))
            vehicle = vehicleMap.get(vehicleModelName);
    
        return vehicle;
    }

    public void registerDriver(Driver driver) {
        if(!driverMap.containsKey(driver.getName())){
            driverMap.put(driver.getName(), driver);
            System.out.println("Driver registered successfully!");
        }
    }

    public Driver getDriverDetails(String driverName){
        Driver driver = null;
        if(driverMap.containsKey(driverName))
            driver = driverMap.get(driverName);
        return driver;
    }

    public void offerRide(Ride ride, int rideId) {
        String vehicleName = ride.getVehicle().getVehicleModelName();
        List<Ride> rides = new ArrayList<Ride>();
        if(!vehicleRidesMap.containsKey(vehicleName)){
            rides.add(ride);
        }else{
            rides = vehicleRidesMap.get(vehicleName);
            rides.add(ride);
        }
        vehicleRidesMap.put(vehicleName, rides);
        rideMap.put(rideId, ride);
    }

    public List<Ride> getAllRidesWithTheSameCarName(String vehicleModelName) {
        if(vehicleRidesMap.containsKey(vehicleModelName))
            return vehicleRidesMap.get(vehicleModelName);
        return new ArrayList<Ride>();
    }

    public List<Ride> getAllRides() {
        List<Ride> allRides = new ArrayList<>();
        allRides.addAll(rideMap.values());
        return allRides;
    }

    public void registerVehicle(Vehicle vehicle) {

        String driverName = vehicle.getVehicleOwner();
        if(userMap.containsKey(driverName)){
            User user =  userMap.get(driverName);
            Driver driver = new Driver(driverName, user.getGender(), user.getAge());
            driverMap.put(driverName, driver);
            vehicleMap.put(driverName+"_"+vehicle.getVehicleIdentificationNumber(), vehicle);
        }
    }

    public void updateSeats(Ride ride, int requestedSeats) {
        int rideId = ride.getId();
        Ride currentRide = rideMap.get(rideId); 
        currentRide.setAvailableSeats(currentRide.getAvailableSeats() - requestedSeats);
        rideMap.put(rideId, currentRide);
    }

    public void updateOfferedRides(String driverName, Ride ride) {
        Driver driver = driverMap.get(driverName);
        driver.getOfferedRides().add(ride);
        driverMap.put(driverName, driver);
    }

    public void updateTakenRides(String passengerName) {
        User user = userMap.get(passengerName);
        user.getTakenRides().add(new Ride());
        userMap.put(passengerName, user);
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public Map<String, Driver> getDriverMap() {
        return driverMap;
    }

}
