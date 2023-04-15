package service;

import dao.RideSharingDao;
import main.entity.User;

public class UserServiceImpl implements UserService{

    RideSharingDao rideSharingDao;
    RideService rideService;
    public UserServiceImpl() {
        rideSharingDao = RideSharingDao.getInstance();
        rideService = new RideServiceImpl();
    }

    
    @Override
    public void registerUser(User user) {
        // TODO Auto-generated method stub
        rideSharingDao.addUser(user);
        //throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
    }


    @Override
    public void requestRide(String passengerName, String origin, String destination, int requestedSeats, String criteria) {
        
        if(rideService.rideAvailable(passengerName,origin, destination, requestedSeats, criteria)){
            
            System.out.println("Ride booked successfully");
        }else{
            System.out.println("No Rides available");
        }
    }   
    
}
