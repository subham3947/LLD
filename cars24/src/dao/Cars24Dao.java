package dao;

import java.util.List;
import java.util.Map;

import entity.Buyer;
import entity.Car;
import entity.Seller;

public class Cars24Dao {

    public static Cars24Dao cars24Dao;
    Map<String, Seller> sellerDetailsMap;
    Map<String, Buyer> buyerDetailsMap;
    Map<String, List<Car>> listedCarsBySeller;
    Map<String, List<Car>> bookmarkedCarsBySeller;

    private Cars24Dao(){};

    public static Cars24Dao getInstance(){
        if(cars24Dao == null)
            cars24Dao = new Cars24Dao();
        return cars24Dao;
    }


    
}
