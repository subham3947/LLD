package observable;

import java.util.ArrayList;
import java.util.List;

import observer.ParkingObserver;

public class CarParkingObservable implements ParkingObservable {

    List<ParkingObserver> carParkingObserverList = new ArrayList<>();
    @Override
    public void add(ParkingObserver parkingObserver) {
       carParkingObserverList.add(parkingObserver);
    }

    @Override
    public void remove(ParkingObserver parkingObserver) {
       carParkingObserverList.remove(parkingObserver);
    }

    @Override
    public void notifyParkingObserver() {
       for(ParkingObserver parkingObserver : carParkingObserverList)
            parkingObserver.action();
    }

    
    
}
