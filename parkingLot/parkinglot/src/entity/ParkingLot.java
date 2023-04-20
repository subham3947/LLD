package entity;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    
    Map<String, Integer> availableSlots;
    Map<String, List<Vehicle>> parkedVehicleMap;
    Map<String, Vehicle> vehicleMap;
    private static ParkingLot instance;

    private ParkingLot(){

    }

    public static synchronized ParkingLot getInstance(){
        if (instance == null)
        {
          //synchronized block to remove overhead
          synchronized (ParkingLot.class)
          {
            if(instance==null)
            {
              // if instance is null, initialize
              instance = new ParkingLot();
            }
           
          }
        }
        return instance;
    }

    public void park(Vehicle vehicle){

    }

    public void unpark(Vehicle vehicle){

    }

    public void getParkedVehicleBYCategory(Vehicle vehicle){

    }

    public void getAllParkedVehicles(Vehicle vehicle){

    }
}
