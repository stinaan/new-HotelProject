package hotel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ReservationFrame implements ChangeListener{
	final int FIELD_WIDTH = 20;
	User theUser;
	String transDate;
	JTextField checkInDateText = new JTextField(FIELD_WIDTH);
	JTextField checkOutDateText = new JTextField(FIELD_WIDTH);

	   ArrayList<ChangeListener> listeners;
	   String whichOne;

	
	
	public ReservationFrame(User aUser)
	{
		this.theUser = aUser;
		this.transDate = "gege";
		
	}

	public void makeReservationFrame(){
		
		JFrame frame = new JFrame();
		final JLabel text = new JLabel("What would you like to do? ");
		
		//add "Make a Reservation" and "makeReservationButton" buttons
		JButton makeReservationButton = new JButton("Make a Reservation");
		JButton ViewCancelButton = new JButton("View/Cancel a Reservation");
		
		
		//add MouseListener to buttons
		makeReservationButton.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						makeReservation();
						frame.dispose();
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
		ViewCancelButton.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
						frame.dispose();
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
		frame.setLayout(new FlowLayout());
		frame.add(text);
		frame.add(makeReservationButton);
		frame.add(ViewCancelButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	
	public void updateCheckIn(String dateString){
		this.checkInDateText.setText(dateString);
	}
	public void updateCheckOut(String dateString){
		this.checkOutDateText.setText(dateString);
	}
	
	public void makeReservation()
	{
		JFrame frame = new JFrame();
		final JLabel roomTypeText = new JLabel("Room type: ");
		
		//add "Sign up" and "Sign in" buttons
		JButton luxuriousButton = new JButton("$300");
		JButton economicButton = new JButton("$100");
		JButton showAllButton = new JButton("Show Me Available Rooms");
		
		//create Check in and Check out Date options
		JPanel cont1 = new JPanel();
		JPanel cont2 = new JPanel();
		final JLabel checkInText = new JLabel("Check in");
		final JLabel checkOutText = new JLabel("Check out");
		
		//make this open GUI calendar
		JButton checkInButton = new JButton("(Month/dd/YYYY)");
		JButton checkOutButton = new JButton("(Month/dd/YYYY)");
		checkInButton.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						//open GUI CALENDAR HERE
					 whichOne = "in";
			        	ViewCalendar calFrame = new ViewCalendar(theUser, whichOne);

						calFrame.viewCalendarFrame();
						//have GUI calendar return start date variables
						frame.dispose();
							
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
		checkOutButton.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						//open GUI CALENDAR HERE
						String whichOne = "out";
			        	ViewCalendar calFrame = new ViewCalendar(theUser, whichOne);

						calFrame.viewCalendarFrame();
						//have GUI calendar return start date variables
						frame.dispose();
							
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
		
		
		//add MouseListeners to buttons
		luxuriousButton.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						/////////need gui calendar
						
						//this is just sample to test//////////// 
						//String inDate = checkInDate.getText();
						//String[] split = inDate.toParse("/");

						//String outDate = checkOutDate.getText();
						//String[] split1 = outDate.toParse("/");
						Date date = new Date(); //remove this once vvvvvvv
						//Date startDate = new Date(split[2], split[0], split[1]);
						//Date endDate = new Date(split1[2], split1[0], split1[1]);
						viewAvailableReservations(date, date, 300);
						frame.dispose();
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
		economicButton.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						/////////need gui calendar
						
						//this is just sample to test////////////
						SimpleDateFormat dt = new SimpleDateFormat("MM/dd/YYYY"); 
						Date date = new Date();
						
						viewAvailableReservations(date, date, 100);
						frame.dispose();
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
		showAllButton.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						/////////need gui calendar
						
						//this is just sample to test////////////
						SimpleDateFormat dt = new SimpleDateFormat("MM/dd/YYYY"); 
						Date date = new Date();
						
						viewAvailableReservations(date, date, 0);
						frame.dispose();
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
		
		
		frame.setLayout(new BorderLayout());
		
		//frame.getContentPane().add(cont1);
		frame.add(cont1, BorderLayout.PAGE_START);
		frame.setSize(400, 300);
		
		//TODO need to add in the selectable date stuffs/////////////
		cont1.add(checkInText);
		cont1.add(checkInButton);
		cont1.add(checkInDateText);
		cont1.add(checkOutText);
		cont1.add(checkOutButton);
		cont1.add(checkOutDateText);
		
		
		cont2.add(roomTypeText);
		cont2.add(luxuriousButton);
		cont2.add(economicButton);
		cont2.add(showAllButton);
		frame.add(cont2, BorderLayout.PAGE_END);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public String toString(String room, String start, String end){
		return String.format("Room #: "+room+" Start date: "+start+" End date: "+end+"\n");
	}
	
	
	
	//////////NEED TO FINISH
	public void viewCancelReservation(){
		JFrame frame = new JFrame();
		final JLabel reservationsText = new JLabel("Your room reservations: ");
		
		//add "cancel"  buttons
		JButton cancelButton = new JButton("Cancel");
		
		//create Check in and Check out Date options
		JPanel cont1 = new JPanel();

		String userID = User.getId();
		File userList = new File("reservations.txt");
	    try {
		Scanner in = new Scanner(new FileReader(userList));
		
		while(in.hasNextLine()){
			
				String currentLine = in.nextLine();
				String[] split = currentLine.split(",");
				
				String tempID = split[0];
				
				if (tempID.equals(userID)){
					JPanel panel = new JPanel();
					String listing = toString(split[3],split[1],split[2]);
					JTextField aListing = new JTextField(listing);
					
					panel.setLayout(new FlowLayout());
					panel.add(aListing);
					panel.add(cancelButton);
					
					//add MouseListeners to buttons
					cancelButton.addMouseListener(
							new MouseListener(){

								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub
									//TODO figure out how to delete text from files
									
									
									frame.repaint();
								}

								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
							});
					
					
				}
				
				
				
	        }	
		}

	        
	     catch (IOException e1) {e1.printStackTrace();}
	
	
		
		
		
		frame.setLayout(new BorderLayout());
		
		
		frame.setSize(400, 300);
		
		//TODO need to add in the selectable date stuffs/////////////
		cont1.add(cancelButton);
		frame.add(reservationsText, BorderLayout.PAGE_START);
		frame.add(cont1, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	public void viewAvailableReservations(Date start, Date end, int roomPrice){
	
		final int FIELD_WIDTH = 30;
		JFrame frame = new JFrame();
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JPanel p4 = new JPanel();
		

		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/YYYY"); 

		final JLabel availRoomsText = new JLabel("Available Rooms  "+dt.format(start)+" - "+dt.format(end));
		p1.add(availRoomsText);
		
		final JLabel desiredRoomText = new JLabel("Please enter your desired room number:");
		JTextField desiredRoomNum = new JTextField(FIELD_WIDTH);
		p2.setLayout(new BorderLayout());
		p2.add(desiredRoomText, BorderLayout.PAGE_START);
		p2.add(desiredRoomNum, BorderLayout.PAGE_END);
		
		
		JButton confirmButton = new JButton("Confirm");
		JButton moreReservButton = new JButton("More Reservations?");
		JButton doneButton = new JButton("Done");
		confirmButton.addMouseListener(
					new MouseListener(){

						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
							
							SimpleDateFormat dt = new SimpleDateFormat("MM/DD/YYYY"); 
							String todayDate = dt.format(new Date());
							
							String emptyAreaError = new String("Please fill out this area");
							boolean startReservation = false;
							
								if((desiredRoomNum.getText()).equals("") || (desiredRoomNum.getText()).equals(emptyAreaError) )
								{
									desiredRoomNum.setText(emptyAreaError);
								}
								else {startReservation = true;}
								
						
							
							if (startReservation == true)
							{
									int desiredRoomNumInt = Integer.parseInt(desiredRoomNum.getText());
									Room rm = new Room(desiredRoomNumInt, roomPrice);
									Reservation newRes = new Reservation(start,end, User.getId(), rm, todayDate);
								    ReservationList.writeReservationToSystem(newRes);
							}
							
							
							
							
						}

						@Override
						public void mouseEntered(MouseEvent e) {
						}

						@Override
						public void mouseExited(MouseEvent e) {
							
						}

						@Override
						public void mousePressed(MouseEvent e) {
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
						}
						
					});
		
		p3.add(confirmButton);
		p3.add(moreReservButton);
		p3.add(doneButton);
		
		p4.setLayout(new BorderLayout());
		p4.add(p2, BorderLayout.PAGE_START);
		p4.add(p3, BorderLayout.CENTER);
		
		
		
		frame.setLayout(new BorderLayout());
		frame.add(p1, BorderLayout.WEST);
		frame.add(p4, BorderLayout.EAST);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	

	
	public void confirmationFrame(){
	
		JFrame frame = new JFrame();
		
		final JLabel confirmText = new JLabel("Reservation(s) is confirmed.");
		final JButton sendBackButton = new JButton("Go Back");
		
		//add MouseListeners to buttons
				sendBackButton.addMouseListener(
						new MouseListener(){

							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub
								
								makeReservationFrame();
								frame.dispose();
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
						});
		
		
		
		
		
		frame.setLayout(new FlowLayout());
		frame.add(confirmText);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if (whichOne.equals("in")){
			checkInDateText.setText(arg0);
		}
		else if (whichOne.equals("out")){
			
			checkOutDateText.setText(arg0);

		}
		
	}
	
	
}
