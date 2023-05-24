package director;

import builder.Builder;
import enums.CarType;
import enums.FuelType;
import enums.Transmission;

public class Director {

    public void buildHatchback(Builder builder){

        builder.setCarType(CarType.HATCHBACK);
        builder.setFuelType(FuelType.DIESEL);
        builder.setMake("HONDA");
        builder.setMileage(18);
        builder.setModel("Brio");
        builder.setPrice(350000);
        builder.setSeats(4);
        builder.setTransmission(Transmission.MANUAL);
        builder.setYear("2015");
        builder.setIsAvailable(true);
    }

    public void buildSedan(Builder builder){

        builder.setCarType(CarType.SEDAN);
        builder.setFuelType(FuelType.PETROL);
        builder.setMake("VOLKSWAGEN");
        builder.setMileage(18);
        builder.setModel("Vento");
        builder.setPrice(1350000);
        builder.setSeats(4);
        builder.setTransmission(Transmission.MANUAL);
        builder.setYear("2017");
        builder.setIsAvailable(true);
    }

    public void buildSUV(Builder builder){

        builder.setCarType(CarType.SUV);
        builder.setFuelType(FuelType.DIESEL);
        builder.setMake("Mahindra");
        builder.setMileage(18);
        builder.setModel("XUV700");
        builder.setPrice(2350000);
        builder.setSeats(7);
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setYear("2020");
        builder.setIsAvailable(true);
    }


    
}
