package hotel;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ViewCalendar
{
    static JLabel month, year;
    static JButton previousButton, nextButton, submitButton;
    static JTable table;
    static JComboBox changeYear;
    static JFrame frame;
    static Container container;
    static DefaultTableModel tableModel; //Table model
    static JScrollPane scrollPane; //The scrollpane
    static JPanel panel;
    static int realYear, realMonth, realDay, currentYear, currentMonth;
    
   static String yearText, monthText, dayText, whichButton;
   static boolean closed = false;
   static User theUser;
   ArrayList<ChangeListener> listeners;

   
   public ViewCalendar(User aUser, String which){
	   this.theUser = aUser;
	   this.whichButton = which;
		listeners = new ArrayList<ChangeListener>();

   }
    
    public static String getYear(){
    	return yearText;
    }
    public static String getMonth(){
    	return monthText;
    }
    public static String getDay(){
    	return dayText;
    }
    
    public static void setYear(String aYr){
    	yearText = aYr;
    }
    public static void setMonth(String aMonth){
    	monthText = aMonth;
    }
    public static void setDay(String aDay){
    	dayText = aDay;
    }
    
    
    public static void viewCalendarFrame()
    {   
        //Prepare frame
        frame = new JFrame("Calendar"); //Create frame
        frame.setSize(330, 375); //Set size to 400x400 pixels
        container = frame.getContentPane(); //Get content pane
        container.setLayout(null); //Apply null layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked
        
        //Create controls
        month = new JLabel("January");
        year = new JLabel("Change year:");
        changeYear = new JComboBox();
        previousButton = new JButton("<--");
        nextButton = new JButton("-->");
        tableModel = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        panel = new JPanel(null);
        submitButton = new JButton("OK");
        //Set border
        panel.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        //Register action listeners
        
        
        table.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				int column = table.getSelectedColumn();
				int row = table.getSelectedRow();
				System.out.println((tableModel.getValueAt(row, column)).toString());
				dayText = (tableModel.getValueAt(row, column)).toString();
				setDay(dayText);
			
			
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
      submitButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ReservationFrame refFrame = new ReservationFrame(theUser);
			if (whichButton.equals("in")){
							refFrame.updateCheckIn(monthText+"/"+dayText+"/"+yearText);

			}
			else
			{
				refFrame.updateCheckOut(monthText+"/"+dayText+"/"+yearText);

			}
			refFrame.makeReservation();
			closed = true;
			frame.dispose();
		}
    	  
      });
        
        
        
        previousButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e)
        													    {
        														if(currentMonth == 11)
        														{ //Foward one year
        															currentMonth = 0;
        															currentYear++;
        														}
        														else
        														{ //Foward one month
        															currentMonth++;
        														}
        														refreshCalendar(currentMonth, currentYear);
        													    }
        													  });
        nextButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e)
        												    {
        														if(currentMonth == 0)
        														{ //Back one year
        															currentMonth = 11;
        															currentYear--;
        														}
        														else
        														{ //Back one month
        															currentMonth--;
        														}
        														refreshCalendar(currentMonth, currentYear);
        												    }
        												  });
        changeYear.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e)
        												    { 
        														if(changeYear.getSelectedItem() != null)
        														{
        															String b = changeYear.getSelectedItem().toString();
        															currentYear = Integer.parseInt(b);
        															refreshCalendar(currentMonth, currentYear);
        														}
        												    }
        												  });
        //Add controls to pane
        container.add(panel);
        panel.add(month);
        panel.add(year);
        panel.add(changeYear);
        panel.add(previousButton);
        panel.add(nextButton);
        panel.add(scrollPane);
        panel.add(submitButton);
        
        //Set bounds
        panel.setBounds(0, 0, 500, 500);
        month.setBounds(160-month.getPreferredSize().width/2, 25, 100, 25);
        year.setBounds(10, 305, 80, 20);
        changeYear.setBounds(135, 305, 80, 20);
        submitButton.setBounds(255, 305, 70, 25);
        previousButton.setBounds(10, 25, 50, 25);
        nextButton.setBounds(260, 25, 50, 25);
        scrollPane.setBounds(10, 50, 300, 250);
        
        
        
        
        //Make frame visible
        frame.setResizable(false);
        frame.setVisible(true);
        
        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realMonth = cal.get(GregorianCalendar.MONTH); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth = realMonth; //Match month and year
        currentYear = realYear;
        
        //Add headers
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for(int i = 0; i < 7; i++)
        {
            tableModel.addColumn(days[i]);
        }
        
        table.getParent().setBackground(table.getBackground()); //Set background
        
        //No resize/reorder
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
       // table.selected
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        table.setRowHeight(38);
        tableModel.setColumnCount(7);
        tableModel.setRowCount(6);
        
        //Populate table
        for(int i = realYear; i <= realYear + 100; i++)
        {
            changeYear.addItem(String.valueOf(i));
        }
        
        //Refresh calendar
        refreshCalendar(realMonth, realYear); //Refresh calendar
    }
    
    public static boolean isClosed()
    {
    	return closed;
    }
    
    public static void refreshCalendar(int aMonth, int year)
    {
        //Variables
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int amountOfDays, beginningOfMonth; //Number Of Days, Start Of Month
        
        //Allow/disallow buttons
        previousButton.setEnabled(true);
        nextButton.setEnabled(true);
        if(aMonth == realMonth && year == realYear)
        {
        	previousButton.setEnabled(false);
        } //Too early
        if(aMonth == 11 && year >= realYear + 100)
        {
        	nextButton.setEnabled(false);
        } //Too late
        month.setText(months[aMonth]); //Refresh the month label (at the top)
        
        
        
        //sets month text to this
        setMonth(months[aMonth]);
        
        
        month.setBounds(160-month.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
        changeYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
      
        
       //sets year text to this
        setYear(String.valueOf(year));


        //Clear table
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                tableModel.setValueAt(null, i, j);
                
                 
            }
            
            
        }
        
        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, aMonth, 1);
        amountOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        beginningOfMonth = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        //Draw calendar
        for (int i = 1; i <= amountOfDays; i++)
        {
        	
            int row = (i + beginningOfMonth - 2) / 7;
            int column = (i + beginningOfMonth - 2) % 7;
            tableModel.setValueAt(i, row, column);
            
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        //Apply renderers
        //tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer
    {
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if(column == 0 || column == 6)
            { //Week-end
                setBackground(new Color(255, 220, 220));
            }
            else
            { //Week
                setBackground(new Color(255, 255, 255));
            }
            if(value != null)
            {
                if(Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear)
                { //Today
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
    
    public void attach(ChangeListener c)
    {
       listeners.add(c);
    }
}