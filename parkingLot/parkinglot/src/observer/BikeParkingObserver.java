package observer;

public class BikeParkingObserver implements ParkingObserver {

    @Override
    public void action() {
        System.out.println("Bike driver notified");
    }
    
}
