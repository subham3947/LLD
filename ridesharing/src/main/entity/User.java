package main.entity;

import java.util.List;

public class User {

    
    String name;
    String gender;
    int age;
    List<Ride> takenRides;

    public List<Ride> getTakenRides() {
        return this.takenRides;
    }

    public void setTakenRides(List<Ride> takenRides) {
        this.takenRides = takenRides;
    }

    public User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User name(String name) {
        setName(name);
        return this;
    }

    public User gender(String gender) {
        setGender(gender);
        return this;
    }

    public User age(int age) {
        setAge(age);
        return this;
    }

    

    
}
