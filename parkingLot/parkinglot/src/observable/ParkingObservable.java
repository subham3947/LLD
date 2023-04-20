package observable;

import observer.ParkingObserver;

public interface ParkingObservable {
    
    public void add(ParkingObserver parkingObserver);

    public void remove(ParkingObserver parkingObserver);

    public void notifyParkingObserver();


}
