package main.entity;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User {

    List<Vehicle> vehicles;
    List<Ride> offeredRides;

    public Driver(String name, String gender, int age) {
        super(name,  gender,  age);
        this.offeredRides = new ArrayList<>();
    }
    
}
