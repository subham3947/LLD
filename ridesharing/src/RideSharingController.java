import java.util.Map;

import main.entity.Ride;
import main.entity.User;
import main.entity.Vehicle;
import service.DriverService;
import service.DriverServiceImpl;
import service.RideService;
import service.RideServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import service.VehicleService;
import service.VehicleServiceImpl;

public class RideSharingController {

    UserService userService;
    DriverService driverService;
    RideService rideService;
    VehicleService vehicleService;
    
    public RideSharingController() {
        userService = new UserServiceImpl();
        driverService = new DriverServiceImpl();
        rideService = new RideServiceImpl();
        vehicleService = new VehicleServiceImpl();
    }

    public void registerUser(String name, String gender, int age){
        User user = new User(name, gender, age);
        userService.registerUser(user);
    }

    public void registerVehicle(String vehicleModelName, String vehicleIdentificationNumber,  String vehicleOwner){
        Vehicle vehicle = new Vehicle(vehicleModelName, vehicleIdentificationNumber, vehicleOwner);
        vehicleService.registerVehicle(vehicle);
    }

    public void offerRide(String ownerName, String origin, int availableSeats, String vehicleName, 
                String vehicleIdentificationNumber, String destination){
        Vehicle vehicle = vehicleService.getRgisteredVehicle(ownerName, vehicleIdentificationNumber);             
        Ride ride = new Ride(vehicle, origin, destination, availableSeats);
        rideService.storeRideDetails(ride);
    }

    public void requestRide(String userName, String origin, int availableSeats, String destination, String criteria){
       userService.requestRide(userName, origin, destination, availableSeats, criteria);
    }

    public void printRideStats(){
        Map<String, Integer[]> rideStats = rideService.getRideStats();
        for(String userName : rideStats.keySet()){
            Integer[] rideTakenAndOffered = rideStats.get(userName);
            System.out.println(userName+" : "+rideTakenAndOffered[0]+" Taken, "+rideTakenAndOffered[1]+" Offered" );
        }
    }

    
}
