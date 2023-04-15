package comparator;

import java.util.Comparator;

import main.entity.Ride;

public class MostVacantSeatsComparator implements Comparator<Ride>{
    
    public int compare(Ride r1, Ride r2)
    {
        return r2.getAvailableSeats() - r1.getAvailableSeats();
    }
}
