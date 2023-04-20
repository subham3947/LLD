package observable;

import java.util.ArrayList;
import java.util.List;

import observer.ParkingObserver;

public class BusParkingObservable implements ParkingObservable{

    List<ParkingObserver> busParkingObserverList = new ArrayList<>();

    @Override
    public void add(ParkingObserver parkingObserver) {
       busParkingObserverList.add( parkingObserver);
    }

    @Override
    public void remove(ParkingObserver parkingObserver) {
        busParkingObserverList.remove(parkingObserver);
    }

    @Override
    public void notifyParkingObserver() {
       for(ParkingObserver parkingObserver : busParkingObserverList){
            parkingObserver.action();

       }
    }

   
    
}
