package service;

import java.util.List;

import dao.FoodKartDao;
import entity.Restaurant;
import entity.Review;
import entity.User;

public class UserServiceImpl implements UserService{

    public UserServiceImpl() {
        this.foodKartDao = FoodKartDao.getInstance();
    }

    FoodKartDao foodKartDao;

    @Override
    public void registerUser(User user) {
        // TODO Auto-generated method stub

        foodKartDao.insertNewUser(user);
        
    }

    @Override
    public void loginUser(String phone) {
        // TODO Auto-generated method stub
        foodKartDao.userLogin(phone);
        
    }

    @Override
    public void logoutUser() {
        // TODO Auto-generated method stub
        foodKartDao.logoutUser();
        
    }

    @Override
    public Review createReview(String restaurant, int rating, String comment) {
        // TODO Auto-generated method stub
        Review review = new Review(comment, rating);
        System.out.println("REview shared by user");
        return review;
        
    }

    
}
