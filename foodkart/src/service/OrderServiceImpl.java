package service;

import java.util.Set;

import dao.FoodKartDao;
import entity.Item;
import entity.Restaurant;
import entity.User;

public class OrderServiceImpl implements OrderService {


    FoodKartDao foodKartDao;

    public OrderServiceImpl() {
        this.foodKartDao = FoodKartDao.getInstance();
    }
    

    @Override
    public void placeOrder(String restaurantName, int orderQuantity) {
        // TODO Auto-generated method stub
        User loggedInUser = foodKartDao.getLoggedInUser();
        if(loggedInUser != null){
            Restaurant restaurant = foodKartDao.getRestaurant(restaurantName);
            if( isQuantityAvailable(restaurant, orderQuantity) && isServiceAvailable(restaurant, loggedInUser)){
                Item item = restaurant.getItem();
                item.setQuantity(item.getQuantity() - orderQuantity);
                restaurant.setItem(item);
                foodKartDao.updateRestaurant(restaurant, restaurantName);
                System.out.println("Order placed successfully.");
            }else{
                System.out.println("Order could not be placed successfully.");
            }

        }else{
            System.out.println("Please login first to place an order.");
        }   
        
    }


    private boolean isQuantityAvailable(Restaurant restaurant, int quantity){

        Item item = restaurant.getItem();
        if(item.getQuantity() < quantity)
            System.out.println("Not enough quantity");
        return (item.getQuantity() >= quantity);
    }

    private boolean isServiceAvailable(Restaurant restaurant, User user){

        Set<String> serviceableLocation = restaurant.getServiceableLocation();
        if(!serviceableLocation.contains(user.getLocation()))
            System.out.println("Location not serviceable");
        return serviceableLocation.contains(user.getLocation());
    }
    
}
