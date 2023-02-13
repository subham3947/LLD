package service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import dao.FoodKartDao;
import entity.Item;
import entity.Restaurant;
import entity.Review;

public class RestaurantServiceImpl implements RestaurantService {

    FoodKartDao foodKartDao;

    public RestaurantServiceImpl() {
        this.foodKartDao = FoodKartDao.getInstance();
    }

    @Override
    public void registerRestaurant(Restaurant restaurant) {
        // TODO Auto-generated method stub
        foodKartDao.registerRestaurant(restaurant);
        
    }

    @Override
    public void showAllRestaurantsSortedByCriteria(String criteria) {
        // TODO Auto-generated method stub
        List<Restaurant> registeredRestaurants = foodKartDao.getAllRegisteredRestaurants();
        if(criteria.equals("rating"))
            Collections.sort(registeredRestaurants, new RestaurantRatingComparator());
        else
            Collections.sort(registeredRestaurants, new RestaurantPriceComparator());
        for(Restaurant restaurant : registeredRestaurants)
            System.out.println(restaurant.getName()+", "+restaurant.getItem().getName());
    }


    @Override
    public void updateQuantity(String restaurantName, int quantity) {
        // TODO Auto-generated method stub
        Restaurant restaurant = foodKartDao.getRestaurant(restaurantName);
        Item item = restaurant.getItem();
        item.setQuantity(item.getQuantity() + quantity);
        restaurant.setItem(item);
        foodKartDao.updateRestaurant(restaurant, restaurantName);
        System.out.println(restaurant.getName()+", "+restaurant.getItem().getQuantity());
    }

    @Override
    public void updateRestaurantLocation(String restaurantName, String newLocation) {
        // TODO Auto-generated method stub
        Restaurant restaurant = foodKartDao.getRestaurant(restaurantName);
        Set<String> serviceableLocation = restaurant.getServiceableLocation();
        String[] locArray = newLocation.split("/");
        for(String loc : locArray)
            serviceableLocation.add(loc);
        restaurant.setServiceableLocation(serviceableLocation);
        foodKartDao.updateRestaurant(restaurant, restaurantName);
        String allLocations = "";
        for(String location : serviceableLocation)
            allLocations += location+"/";
        System.out.println(restaurant.getName()+", "+allLocations);
    }

    public void updateRestaurantRating(String restaurantName, Review review) {
        // TODO Auto-generated method stub
        Restaurant restaurant = foodKartDao.getRestaurant(restaurantName);
        List<Review> reviews = restaurant.getReviews();
        reviews.add(review);
        double avgRating = 0.0;
        for(Review rev : reviews)
            avgRating += rev.getRating();
        avgRating /= reviews.size();
        restaurant.setAvgRating(avgRating);
        foodKartDao.updateRestaurant(restaurant, restaurantName);
    }
    

    class RestaurantRatingComparator implements Comparator<Restaurant>{

        @Override
        public int compare(Restaurant r1, Restaurant r2) {
            // TODO Auto-generated method stub
            return (int)r1.getAvgRating() -  (int)r2.getAvgRating();
        }
    }

    class RestaurantPriceComparator implements Comparator<Restaurant>{

        @Override
        public int compare(Restaurant r1, Restaurant r2) {
            // TODO Auto-generated method stub
            return r1.getItem().getPrice() -  r2.getItem().getPrice();
        }
    
    
    }
    
    
    
    
}
