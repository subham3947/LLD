package observer;

public class CarParkingObserver implements ParkingObserver {

    @Override
    public void action() {

        System.out.println("Car driver notified");
        
    }
    
}
