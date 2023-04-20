package entity;

import java.security.Timestamp;

public class Car extends Vehicle{

    public Car(String type, String licensePlateNumber, Timestamp entryTime) {
        super(type, licensePlateNumber, entryTime);
    }
}
