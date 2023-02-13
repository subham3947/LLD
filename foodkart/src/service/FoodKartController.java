package service;

import java.util.HashSet;
import java.util.Set;

import entity.Item;
import entity.Restaurant;
import entity.Review;
import entity.User;

public class FoodKartController {

    
    UserService userService;
    RestaurantService restaurantService;
    OrderService orderService;

    public FoodKartController() {
        userService = new UserServiceImpl();
        restaurantService = new RestaurantServiceImpl();
        orderService = new OrderServiceImpl();
    }

    public void registerUser(String name, String gender, String phone, String location) {

        User user = new User(name, gender, phone, location);
        userService.registerUser(user);
        System.out.println("User registered successfully");
    }

    public void registerRestaurant(String restaurantName, String location, String itemName, int itemPrice, int itemQuantity) {
       
        Item item = new Item(itemName, itemPrice, itemQuantity);
        Set<String> serviceableLocation = new HashSet<String>();
        String[] locArray = location.split("/");
        for(String loc : locArray)
            serviceableLocation.add(loc);
        Restaurant restaurant = new Restaurant(restaurantName, item, serviceableLocation);
        restaurantService.registerRestaurant(restaurant);
        System.out.println("Restaurant registered successfully");
    }

    public void loginUser(String phone) {
        userService.loginUser(phone);
        System.out.println("User logged in successfully");
    }

    public void showRestaurants(String criteria) {
        restaurantService.showAllRestaurantsSortedByCriteria(criteria);
        System.out.println("User registered successfully");
    }

    public void placeOrder(String restaurantName, int itemQuantity) {
        orderService.placeOrder(restaurantName, itemQuantity);
    }

    public void updateLocation(String restaurantName, String newLocation) {
        restaurantService.updateRestaurantLocation(restaurantName, newLocation);
    }

    public void createReview(String restaurantName, int rating, String comments) {
        Review review = userService.createReview(restaurantName, rating, comments);
        RestaurantService restaurantService = new RestaurantServiceImpl();
        restaurantService.updateRestaurantRating(restaurantName, review);
        System.out.println("Restaurant review updated");
    }
}
