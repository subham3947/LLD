package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.RideSharingDao;
import main.entity.Driver;
import main.entity.Ride;
import main.entity.User;
import main.entity.Vehicle;
import service.DriverService;
import service.DriverServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import service.VehicleService;
import service.VehicleServiceImpl;

public class DriverServiceTest {
    
    RideSharingDao rideSharingDao;
    VehicleService vehicleService;
    DriverService driverService;
    UserService userService;
    User user;
    Vehicle vehicle;

    @Before
    public void setup(){
        rideSharingDao = RideSharingDao.getInstance();
        driverService = new DriverServiceImpl();
        userService = new UserServiceImpl();
        vehicleService = new VehicleServiceImpl();
        user = new Driver("Rohan", "M", 26);
        vehicle = new Vehicle("Swift", "KA-01-12345", "Rohan");
    }

    @Test
    public void offerRideTestWhenDriverIsRegistered(){
        userService.registerUser(user);
        vehicleService.registerVehicle(vehicle);
        String vehicleKey = user.getName()+"_"+vehicle.getVehicleIdentificationNumber();
        Vehicle vehicle = rideSharingDao.getVehicleDetails(vehicleKey);
        Ride ride = new Ride(vehicle, "Hyderabad", "Bangalore", 1);
        driverService.offerRide(ride);
        List<Ride> rides = rideSharingDao.getAllRidesWithTheSameCarName(vehicle.getVehicleModelName());
        Ride actualRide = null;
        
        for(Ride r : rides){
            if(r.getVehicle().getVehicleIdentificationNumber() == vehicle.getVehicleIdentificationNumber()){
                actualRide = r;
                break;
            }
        }
        assertEquals(ride, actualRide);

    }

    @Test
    public void offerRideTestWhenAlreadyRideHasBeenOfferedByTheSameVehicle(){
       offerRideTestWhenDriverIsRegistered();
       Ride ride = new Ride(vehicle, "Bangalore", "Pune", 1);
       driverService.offerRide(ride);
       List<Ride> rides = rideSharingDao.getAllRidesWithTheSameCarName(vehicle.getVehicleModelName());
       int count = 0;
       for(Ride r : rides){
           if(r.getVehicle().getVehicleIdentificationNumber() == vehicle.getVehicleIdentificationNumber()){
               count++;
           }
       }
       assertEquals(1, count);
    }
}
