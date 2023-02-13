package service;

import java.util.List;

import entity.Restaurant;
import entity.Review;

public interface RestaurantService {
    

    public void registerRestaurant(Restaurant restaurant);

    public void showAllRestaurantsSortedByCriteria(String criteria);

    public void updateQuantity(String name, int quantity);

    public void updateRestaurantLocation(String name, String location);

    /*
     * This method updates the rating of the
     * Restaurant.
     */
    public void updateRestaurantRating(String restaurantName, Review review);
    
}
