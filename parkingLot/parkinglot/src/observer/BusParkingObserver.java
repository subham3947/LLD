package observer;

public class BusParkingObserver implements ParkingObserver{

    @Override
    public void action() {

        System.out.println("Bus driver notified");
        
    }
    
}
