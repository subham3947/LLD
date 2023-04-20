package entity;

import java.security.Timestamp;

public class Vehicle {
    
    String type;
    String licensePlateNumber;
    Timestamp entryTime; 
    

    public Vehicle(String type, String licensePlateNumber, Timestamp entryTime) {
        this.type = type;
        this.licensePlateNumber = licensePlateNumber;
        this.entryTime = entryTime;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicensePlateNumber() {
        return this.licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public Timestamp getEntryTime() {
        return this.entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    

    
}
