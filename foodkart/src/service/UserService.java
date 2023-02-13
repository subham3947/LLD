package service;

import entity.Review;
import entity.User;

public interface UserService {

    public void registerUser(User user);

    public void loginUser(String phone);

    public void logoutUser();

    public Review createReview(String restaurant, int rating, String comment);

    
}
