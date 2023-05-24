package entity;

import java.util.List;

public class Buyer extends UserAccount {
    
    List<Car> bookmarkedCars;

    public Buyer(List<Car> bookmarkedCars) {
        super();
    }

}
