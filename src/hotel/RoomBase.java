package hotel;
import java.time.LocalDate;

public interface RoomBase 
{
	public int getRoomNumber();
	public int getRoomPrice();
	public String getRoomType();
	public ReservationList getReservations();
	public void setRoomType(String type);
	public void setReservation(ReservationList rl);
	public void addReservation(Reservation r);
	public void cancelReservation(Reservation r);
	
	
}