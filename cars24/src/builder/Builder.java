package builder;

import entity.Car;
import enums.CarType;
import enums.FuelType;
import enums.Transmission;

public interface Builder {

    public void setMake(String make);

    public void setModel(String model) ;

    public void setSeats(int seats) ;

    public void setYear(String year);

    public void setMileage(double mileage) ;

    public void setPrice(int price) ;

    public void setTransmission(Transmission transmission) ;

    public void setCarType(CarType carType) ;

    public void setFuelType(FuelType fuelType) ;

    public void setIsAvailable(boolean isAvailable) ;

    public Car getCar();
    
}
