import builder.Builder;
import builder.CarBuilder;
import director.Director;
import entity.Car;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Director director =  new Director();
        Builder builder = new CarBuilder();
        director.buildSUV(builder);
        Car suv = builder.getCar();
        System.out.println("Number of seats in SUV are : "+suv.getSeats());
        director.buildSedan(builder);
        Car sedan = builder.getCar();
        System.out.println("Number of seats in SUV are : "+sedan.getCarType());
    }
}
