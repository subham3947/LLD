package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import dao.RideSharingDao;
import exception.UserNotFoundException;
import exception.VehicleAlreadyRegistered;
import main.entity.User;
import main.entity.Vehicle;
import service.UserService;
import service.UserServiceImpl;
import service.VehicleService;
import service.VehicleServiceImpl;

public class VehicleServiceTest {
    
    RideSharingDao rideSharingDao;
    Vehicle vehicle1;
    VehicleService vehicleService;
    User user;
    
    @Before
    public void setup(){
        vehicleService = new VehicleServiceImpl();
        rideSharingDao = RideSharingDao.getInstance();
        user = new User("Rohan","M", 29);
        vehicle1 = new Vehicle("Swift", "KA-01-12345", "Rohan");
    }

    @Test
    public void registerVehicleTestWhenUserIsNotRegistered() throws UserNotFoundException, VehicleAlreadyRegistered{
        VehicleService vehicleService = new VehicleServiceImpl();
    
        vehicleService.registerVehicle(vehicle1);
        Vehicle actualOutput =    rideSharingDao.getVehicleDetails(vehicle1.getVehicleModelName());
        assertEquals(null, actualOutput);
    }

    @Test
    public void registerVehicleTestWhenUserIsRegistered() {
        
        UserService userService = new UserServiceImpl();
        userService.registerUser(user);
        vehicleService.registerVehicle(vehicle1);
        Vehicle actualOutput =    rideSharingDao.getVehicleDetails(user.getName()+"_"+vehicle1.getVehicleIdentificationNumber());
        assertEquals(vehicle1.getVehicleIdentificationNumber(), actualOutput.getVehicleIdentificationNumber());
        
    }
}
