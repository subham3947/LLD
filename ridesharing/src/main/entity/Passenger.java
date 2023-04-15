package main.entity;

import java.util.ArrayList;
import java.util.List;

public class Passenger extends User {

    List<Ride> takenRides;

    public Passenger(String name, String gender, int age) {
        super(name,  gender,  age);
        this.takenRides = new ArrayList<>();
    }
    
}
