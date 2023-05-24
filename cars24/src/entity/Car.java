package entity;
import enums.CarType;
import enums.FuelType;
import enums.Transmission;

public class Car {
    String make;
    String model;
    int seats;
    String year;
    double mileage;
    int price;
    Transmission transmission;
    CarType carType;
    FuelType fuelType;
    boolean available;

    public boolean isAvailable() {
        return this.available;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getMileage() {
        return this.mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return this.transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public CarType getCarType() {
        return this.carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
    
}
