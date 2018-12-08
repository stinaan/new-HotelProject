package hotel;

import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

public class ViewFrame {
	
	public ArrayList<Reservation> allReservations;
	
	
	public ViewFrame(ArrayList<Reservation> l){
		allReservations = l;
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		JLabel roomTitle = new JLabel("Select the room number");
		RoomList roomList = new RoomList();
		ArrayList<Room> list = roomList.getRooms();
		
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());
			JPanel panel1 = new JPanel();
			panel1.setLayout(new BorderLayout());
			JPanel panel2 = new JPanel();
			panel2.setLayout(new BorderLayout());
		for (int i = 1; i <=list.size(); i++){
			
			JButton roomButton = new JButton("Room "+i);
			roomButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			if(i%10==0){
				
			}
			
			panel.add(roomButton);
			
			//if (i%5 == 0)//is divisible by 5
			{
				if (i == 5){
					
				panel1.add(panel, BorderLayout.NORTH);
				}
				
				if (i ==10){
					panel1.add(panel, BorderLayout.SOUTH);
				}
				
				//if (i% 10 == 0)
				{
					if(i==15){
						
					panel2.add(panel, BorderLayout.NORTH);
					}
					
					if(i==20){
						
						panel2.add(panel, BorderLayout.SOUTH);
						}
					
				}

			}
			
			if(i%5 == 0){
				panel = new JPanel();
			}
			
			
		}
		JPanel panel0 = new JPanel();
		panel0.setLayout(new BorderLayout());
		panel0.add(roomTitle, BorderLayout.NORTH);
		panel0.add(panel1, BorderLayout.SOUTH);
		
		//frame.add(roomTitle,BorderLayout.NORTH);
		frame.add(panel0,BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);
		
		
		
		DateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		for(Reservation r: allReservations){
			
			Date start = r.getStartDate();
			//start.getMonth().to
			String theStart = format.format(start);
			System.out.println(theStart);

			Date end = r.getEndDate();
			String theEnd = format.format(end);

			int roomNum = r.getRoomNumber();
			
			
		}

		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		ViewCalendar cal = new ViewCalendar(frame);
		String date = cal.getDay();
		String month = cal.getMonth();
		String year = cal.getYear();
		System.out.println(date+month+year);
	}
	
	

}
