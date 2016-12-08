import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MyFrame extends JFrame {

	private JPanel mainPanel=new JPanel();
	private JPanel sellingPanel=new JPanel();
	private JPanel panel3=new JPanel();
	private JPanel panel4=new JPanel();

	private JButton backButton = new JButton("Back");

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(400, 350);
		setTitle("Bus Company");
		setLayout(new BorderLayout());

		//*****Main Panel*****

		JButton sellingButton=new JButton("Ticket Selling");
		JButton reservationButton=new JButton("Ticket Reservation");
		JButton cancelationButton=new JButton("Ticket Cancelation");
		JButton infoShuttleButton=new JButton("Information about Shuttles");

		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,80,25));

		mainPanel.add(sellingButton);
		mainPanel.add(reservationButton);
		mainPanel.add(cancelationButton);
		mainPanel.add(infoShuttleButton);

		mainPanel.setVisible(true);
		add(mainPanel,BorderLayout.CENTER);


		//*****Ticket Selling Panel*****

		String [] departurePoints={"Istanbul","Ankara","Izmir","Adana","Antalya"};
		String [] arrivalPoints={"Istanbul","Ankara","Izmir","Adana","Antalya"};
		String [] days={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String [] months={"01","02","03","04","05","06","07","08","09","10","11","12"};
		String [] years={"2016","2017"};

		JTextField nameText=new JTextField(5);
		JTextField phoneText=new JTextField(5);
		JComboBox departureBox=new JComboBox(departurePoints);
		JComboBox arrivalBox=new JComboBox(arrivalPoints);
		JComboBox daysBox=new JComboBox(days);
		JComboBox monthsBox=new JComboBox(months);
		JComboBox yearsBox=new JComboBox(years);
		JButton searchButton = new JButton("Search");
		JRadioButton roundRButton = new JRadioButton("Round Trip");
		JRadioButton onewayRButton = new JRadioButton("One Way");
		ButtonGroup bg=new ButtonGroup();
		bg.add(onewayRButton);
		//		bg.add(roundRButton);
		JTextField onewayDate=new JTextField(5);
		JTextField roundtripDate=new JTextField(5);

		sellingPanel.setLayout (new FlowLayout(FlowLayout.LEFT,20,20));

		sellingPanel.add(new JLabel("Full Name"));
		sellingPanel.add(nameText);
		sellingPanel.add(new JLabel("Phone Number"));
		sellingPanel.add(phoneText);
		sellingPanel.add(new JLabel("From"));
		sellingPanel.add(departureBox);
		sellingPanel.add(new JLabel("to"));
		sellingPanel.add(arrivalBox);
		sellingPanel.add(new JLabel(""));

		sellingPanel.add(onewayRButton);
		//		sellingPanel.add(roundRButton);
		onewayRButton.setSelected(true);
//		sellingPanel.add(new JLabel("                                "));

		sellingPanel.add(new JLabel("Dept. Date"));
//		sellingPanel.add(onewayDate);
		//		sellingPanel.add(new JLabel("Return Date"));
		//		sellingPanel.add(roundtripDate);
		sellingPanel.add(daysBox);
		sellingPanel.add(monthsBox);
		sellingPanel.add(yearsBox);

		sellingPanel.add(searchButton);
		sellingPanel.add(backButton, BorderLayout.SOUTH);

		sellingPanel.setBorder(new TitledBorder("Ticket Selling"));

		sellingPanel.setVisible(false);
		add(sellingPanel,BorderLayout.CENTER);
		//		roundtripDate.addActionListener(new RButtonsListener());
		sellingButton.addActionListener(new sellingTicketListener());
		backButton.addActionListener(new backButtonListener());
		
	}

	public class RButtonsListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			
		}
	}

	public class backButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			mainPanel.setVisible(true);
			sellingPanel.setVisible(false);
		}
	}

	public class sellingTicketListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			mainPanel.setVisible(false);
			sellingPanel.setVisible(true);
		}
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
