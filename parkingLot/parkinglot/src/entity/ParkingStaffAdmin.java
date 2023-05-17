package entity;


import observable.BikeParkingObservable;
import observable.BusParkingObservable;
import observable.CarParkingObservable;
import observable.ParkingObservable;
import observer.BikeParkingObserver;
import observer.BusParkingObserver;
import observer.CarParkingObserver;

public class ParkingStaffAdmin extends ParkingStaff{
    
    ParkingObservable observable;
    ParkingLot parkingLot;

    public ParkingStaffAdmin(String name) {
        super(name);
        parkingLot = ParkingLot.getInstance();
    }

    public void handleParking(Vehicle vehicle){

        



    }

    public void handleUnparking(){

    }

    public void notifyVehicle(Vehicle vehicle){

        if(vehicle instanceof Bike){
            observable = new BikeParkingObservable();
        }else if(vehicle instanceof Car)
            observable = new CarParkingObservable();
        else{
            observable = new BusParkingObservable();
        }
        observable.notify();

    }

    public void addToWaitingList(Vehicle vehicle){

        if(vehicle instanceof Bike){
            observable = new BikeParkingObservable();
            observable.add(new BikeParkingObserver());
        }else if(vehicle instanceof Car){
            observable = new CarParkingObservable();
            observable.add(new CarParkingObserver());
        }
        else{
            observable = new BusParkingObservable();
            observable.add(new BusParkingObserver());
        }


    }
    
}
