package hotel;

import java.util.ArrayList;
import java.time.LocalDate;

public class LuxuriousRoom extends Room
{
	private ArrayList<LocalDate> bookedLuxDates;
	private int rate;
	
	public LuxuriousRoom(int roomNum, int price)
	{
		bookedLuxDates = new ArrayList<LocalDate>();
		rate = 300;
		Room aRoom = new Room();
		
	}
	

	
	public int getRate()
	{
		return rate;
	}
}
