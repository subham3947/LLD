package builder;

import entity.Car;
import enums.CarType;
import enums.FuelType;
import enums.Transmission;

public class CarBuilder implements Builder {

    private Car car;

    public CarBuilder(){
        car = new Car();
    }

    @Override
    public void setMake(String make) {
        car.setMake(make);
    }

    @Override
    public void setModel(String model) {
        car.setModel(model);
    }

    @Override
    public void setSeats(int seats) {
        car.setSeats(seats);
    }

    @Override
    public void setYear(String year) {
       car.setYear(year);
    }

    @Override
    public void setMileage(double mileage) {
        car.setMileage(mileage);
    }

    @Override
    public void setPrice(int price) {
       car.setPrice(price);
    }

    @Override
    public void setTransmission(Transmission transmission) {
        car.setTransmission(transmission);
    }

    @Override
    public void setCarType(CarType carType) {
        car.setCarType(carType);
    }

    @Override
    public void setFuelType(FuelType fuelType) {
        car.setFuelType(fuelType);
    }

    public void setIsAvailable(boolean available) {
        car.setAvailable(available);
    }

    public Car getCar(){
        return car;
    }


    
}
