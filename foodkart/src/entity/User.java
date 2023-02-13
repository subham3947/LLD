package entity;

import java.util.List;

public class User {

    String name;
    String gender;
    String phoneNumber;
    String location;

    public User(String name, String gender, String phoneNumber, String location) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
    List<Order> orderHistory;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String pincode) {
        this.location = pincode;
    }

    public List<Order> getOrderHistory() {
        return this.orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }
    
}

