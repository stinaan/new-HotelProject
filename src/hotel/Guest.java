package hotel;

import java.util.ArrayList;
import java.util.Date;

public class Guest extends User{
	
    private ArrayList<Reservation> currentTransaction;

	public Guest(String username, String id, String password) {
		super(username, id, password);
        currentTransaction = new ArrayList<Reservation>();
	}
 	
    public ArrayList<Reservation> getCurrentReservation() {
    	return currentTransaction;
    }
    
	public void viewAllReservations(String id, ReservationList rl) {
		rl.loadUserReservations(id);
	}
	
	public void makeReservation(Date checkInDate, Date checkOutDate, String id, ReservationList rl) {
		Reservation r = new Reservation(checkInDate,checkOutDate, id);
		rl.add(r);
		currentTransaction.add(r);
	}
	
	public void cancelCurrentTransaction() {
		currentTransaction.clear();
	}
	
	public void cancelReservation(Reservation r, ReservationList rl) {
		rl.cancel(r);
	}
}
