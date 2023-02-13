package entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Restaurant {

    String name;
    Item item;
    Set<String> serviceableLocation;
    List<Review> reviews;
    double avgRating;

    public Restaurant(String name, Item item, Set<String> serviceableLocation) {
        this.name = name;
        this.item = item;
        this.serviceableLocation = serviceableLocation;
        this.reviews = new ArrayList<>();
    }
   

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    

    public Set<String> getServiceableLocation() {
        return this.serviceableLocation;
    }

    public void setServiceableLocation(Set<String> location) {
        this.serviceableLocation = location;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    

    public double getAvgRating() {
        return this.avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

}

