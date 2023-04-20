package observable;

import java.util.ArrayList;
import java.util.List;

import observer.ParkingObserver;

public class BikeParkingObservable implements ParkingObservable{

    List<ParkingObserver> bikeObserverList = new ArrayList<>();;
    @Override
    public void add(ParkingObserver bikeParkingObserver) {
        bikeObserverList.add(bikeParkingObserver);
    }

    @Override
    public void remove(ParkingObserver bikeParkingObserver) {
        bikeObserverList.remove(bikeParkingObserver);
    }

    @Override
    public void notifyParkingObserver() {

        for(ParkingObserver parkingObserver : bikeObserverList)
            parkingObserver.action();
        
    }
    
}
