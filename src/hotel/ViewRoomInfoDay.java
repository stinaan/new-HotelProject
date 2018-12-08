package hotel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

public class ViewRoomInfoDay {
	ArrayList<Room> roomList;
	
	public ViewRoomInfoDay(ArrayList l){
		roomList = l;
	JFrame frame = new JFrame();
	
	JLabel roomInfoText = new JLabel("Room information");
	
	JLabel availRoomText = new JLabel("Available rooms: ");
	JPanel availRoomPanel = new JPanel();
	availRoomPanel.setLayout(new BorderLayout());
	availRoomPanel.add(availRoomText, BorderLayout.NORTH);
	JPanel availRoomListing = new JPanel();
	availRoomPanel.add(availRoomListing, BorderLayout.CENTER);
	
	
	
	JLabel reservedRoomText = new JLabel("Reserved Rooms:");
	JPanel reservedRoomPanel = new JPanel();
	reservedRoomPanel.setLayout(new BorderLayout());
	reservedRoomPanel.add(reservedRoomText, BorderLayout.NORTH);
	JPanel reservedRoomListing = new JPanel();
	reservedRoomPanel.add(reservedRoomListing,BorderLayout.CENTER);
	

	
	
	
	
	
	
	
	frame.setLayout(new BorderLayout());
	frame.add(roomInfoText, BorderLayout.NORTH);
	frame.add(availRoomPanel, BorderLayout.CENTER);
	frame.add(reservedRoomPanel, BorderLayout.SOUTH);
	
	
	}
	
	
}
