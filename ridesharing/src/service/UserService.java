package service;

import main.entity.User;

public interface UserService {

    public void registerUser(User user);

    public void requestRide(String passengername, String origin, String destination, int seats, String criteria);

    
    
}
