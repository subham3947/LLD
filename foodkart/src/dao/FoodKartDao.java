package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Restaurant;
import entity.User;

public class FoodKartDao {

    static FoodKartDao foodKartDaoInstance;
    
    User loggedInUser;
    Map<String, User> registeredUser;
    Map<String, Restaurant> registeredRestaurant;

    public FoodKartDao() {
        
        this.registeredUser = new HashMap<>();
        this.registeredRestaurant = new HashMap<>();
    }

    public User getLoggedInUser() {
        return this.loggedInUser;
    }


    public static FoodKartDao getInstance(){
        if(foodKartDaoInstance == null)
            foodKartDaoInstance =  new FoodKartDao();
        return foodKartDaoInstance;
    }

    public void insertNewUser(User user) {

        if(user != null)
            registeredUser.put(user.getPhoneNumber(), user);
    }


    public void userLogin(String phone) {
        if(phone != null)
            loggedInUser = registeredUser.get(phone);
    }

    public void logoutUser() {
        loggedInUser = null;
    }


    public void registerRestaurant(Restaurant restaurant) {

        if(restaurant != null)
             registeredRestaurant.put(restaurant.getName(), restaurant);
    }


    public List<Restaurant> getAllRegisteredRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        for(String restaurantName : registeredRestaurant.keySet())
            restaurants.add(registeredRestaurant.get(restaurantName));
        return restaurants;
    }


    public Restaurant getRestaurant(String name) {
        Restaurant restaurant = null;
        if(name != null)
            restaurant = registeredRestaurant.get(name);
        return restaurant;
    }


    public void updateRestaurant(Restaurant restaurant, String name) {
        if(name != null)
            registeredRestaurant.put(name, restaurant);
    }
    
}
