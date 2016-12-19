import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MyFrame extends JFrame {

	private JPanel mainPanel=new JPanel();
	private JPanel sellingPanel=new JPanel();
	private JPanel searchPanel=new JPanel();
	private JPanel cancelationPanel=new JPanel();
	private JPanel shuttlesPanel=new JPanel();

	//*****Selling Panel*****

	private String [] departurePoints={"Istanbul","Ankara","Izmir"};
	String [] arrivalPoints={"Istanbul","Ankara","Izmir"};
	String [] numofSeat={"1","2","3","4","5","6","7","8","9","10"};
	private final JComboBox departureBox=new JComboBox(departurePoints);
	private final JComboBox arrivalBox=new JComboBox(arrivalPoints);
	private JButton backButton = new JButton("Back");

	//******Search Panel******

	private JTextField nameText=new JTextField(5);
	JTextField phoneText=new JTextField(5);
	JRadioButton r1=new JRadioButton("11:00");
	JRadioButton r2=new JRadioButton("15:00");
	JRadioButton r3=new JRadioButton("20:00");
	private ButtonGroup group=new ButtonGroup();
	private JButton back2Button = new JButton("Back");

	//*****Inside Panel*(in the Search Panel)****
	private JTextArea textpanel = new JTextArea(5,30);
	private JComboBox numofSeats=new JComboBox(numofSeat);
	private JButton buyButton = new JButton("BUY");

	//*****Cancelation Panel*****

	private JTextField ticketID=new JTextField(6);
	private JButton cancelButton = new JButton("Cancel it!");
	private JButton backButton4 = new JButton("Back");

	//****Information Panel****
	private JTextArea shuttleTextArea = new JTextArea(6,35);
	private JButton back3Button = new JButton("Back");


	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(406, 330);
		setLocationRelativeTo(null);
		setTitle("Bus Company");
		setLayout(new BorderLayout());

		//*****Main Panel*****
		JButton sellingButton=new JButton("Ticket Selling");
		sellingButton.setPreferredSize(new Dimension(200, 40));
		JButton cancelationButton=new JButton("Ticket Cancelation");
		cancelationButton.setPreferredSize(new Dimension(200, 40));
		JButton infoShuttleButton=new JButton("Information about Shuttles");
		infoShuttleButton.setPreferredSize(new Dimension(200, 40));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,80,25));
		mainPanel.add(sellingButton);
		mainPanel.add(cancelationButton);
		mainPanel.add(infoShuttleButton);
		mainPanel.setVisible(true);
		add(mainPanel,BorderLayout.CENTER);


		//*****Ticket Selling Panel*****

		String [] days={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String [] months={"01","02","03","04","05","06","07","08","09","10","11","12"};
		String [] years={"2016","2017"};

		JComboBox daysBox=new JComboBox(days);
		JComboBox monthsBox=new JComboBox(months);
		JComboBox yearsBox=new JComboBox(years);
		JButton searchButton = new JButton("Search");
		//		JRadioButton roundRButton = new JRadioButton("Round Trip");
		//		JRadioButton onewayRButton = new JRadioButton("One Way");
		//		ButtonGroup bg=new ButtonGroup();
		//		bg.add(onewayRButton);
		//		bg.add(roundRButton);
		JTextField onewayDate=new JTextField(5);
		//		JTextField roundtripDate=new JTextField(5);
		sellingPanel.setLayout (new FlowLayout(FlowLayout.LEFT,20,20));
		sellingPanel.add(new JLabel("From"));
		sellingPanel.add(departureBox);
		sellingPanel.add(new JLabel("to"));
		sellingPanel.add(arrivalBox);
		sellingPanel.add(new JLabel("                           "));
		//		sellingPanel.add(onewayRButton);
		//		onewayRButton.setSelected(true);
		sellingPanel.add(new JLabel("Dept. Date"));
		sellingPanel.add(daysBox);
		sellingPanel.add(monthsBox);
		sellingPanel.add(yearsBox);
		sellingPanel.add(new JLabel("                           "));
		sellingPanel.add(searchButton);
		sellingPanel.add(backButton, BorderLayout.SOUTH);
		sellingPanel.setBorder(new TitledBorder("Ticket Selling"));
		sellingPanel.setVisible(false);
		add(sellingPanel,BorderLayout.CENTER);

		sellingButton.addActionListener(new sellingTicketListener());
		backButton.addActionListener(new backButtonListener());

		//******Search Panel******
		group.add(r1);
		group.add(r2);
		group.add(r3);
		searchPanel.setBorder(new TitledBorder("Search Panel"));
		searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER,25,20));
		searchPanel.add(new JLabel("Full Name"));
		searchPanel.add(nameText);
		searchPanel.add(new JLabel("Phone Number"));
		searchPanel.add(phoneText);
		JPanel insidePanel = new JPanel();
		insidePanel.setLayout(new GridLayout(1,3));
		insidePanel.setBorder(new TitledBorder("Hours & NumberofSeat"));
		searchPanel.add(insidePanel);
		r1.setSelected(true);
		insidePanel.add(r1);
		insidePanel.add(r2);
		insidePanel.add(r3);
		insidePanel.add(new JLabel(" "));
		insidePanel.add(numofSeats);
		searchPanel.add(textpanel);
		searchPanel.add(back2Button);
		searchPanel.add(buyButton);
		searchPanel.setVisible(false);

		back2Button.addActionListener(new back2ButtonListener());
		searchButton.addActionListener(new searchButtonListener());
		buyButton.addActionListener(new buyButtonListener());

		//*****Cancelation Panel*****
		cancelationPanel.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		cancelationPanel.add(new JLabel("Ticket ID:"));
		cancelationPanel.add(new JLabel(""));
		cancelationPanel.add("North",ticketID);
		cancelationPanel.add("South",cancelButton);
		cancelButton.setPreferredSize(new Dimension(110,26));
		cancelationPanel.add("South",backButton4);
		cancelationPanel.setVisible(false);

		cancelationButton.addActionListener(new cancelationButtonListener());
		backButton4.addActionListener(new back4ButtonListener());
		cancelButton.addActionListener(new cancelButtonListener());

		//*****Shuttles Panel*******
		shuttlesPanel.add(new JLabel("Shuttle Information"));
		shuttlesPanel.add(shuttleTextArea);
		shuttlesPanel.add(back3Button);
		shuttlesPanel.setVisible(false);

		infoShuttleButton.addActionListener(new shuttleButtonListener());
		back3Button.addActionListener(new back3ButtonListener());

	}


	//*****Button Listeners*****

	public class sellingTicketListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			add(sellingPanel);
			mainPanel.setVisible(false);
			sellingPanel.setVisible(true);

		}
	}

	public class cancelationButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			add(cancelationPanel);
			mainPanel.setVisible(false);
			cancelationPanel.setVisible(true);
		}
	}

	public class shuttleButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			add(shuttlesPanel);
			shuttlesPanel.setVisible(true);
			mainPanel.setVisible(false);

			File fs = new File("shuttle.txt");
			Scanner shuttles;
			String a = "";
			try{
				shuttles = new Scanner(fs);
				while(shuttles.hasNextLine()){
					String x = shuttles.nextLine();
					a+=x+"\n";
				}

			}
			catch(FileNotFoundException e1){
				e1.printStackTrace();
			}	
			shuttleTextArea.setText(a);
			shuttleTextArea.setEditable(false);

		}
	}

	public class backButtonListener implements ActionListener{//for sellingPanel
		public void actionPerformed (ActionEvent e){
			sellingPanel.setVisible(false);
			mainPanel.setVisible(true);
		}
	}

	public class back2ButtonListener implements ActionListener{//for insidePanel
		public void actionPerformed (ActionEvent e){
			mainPanel.setVisible(false);
			sellingPanel.setVisible(true);
			searchPanel.setVisible(false);
		}
	}

	public class back3ButtonListener implements ActionListener{//for shuttleinfoPanel
		public void actionPerformed (ActionEvent e){
			shuttlesPanel.setVisible(false);
			mainPanel.setVisible(true);
		}
	}

	public class back4ButtonListener implements ActionListener{//for cancelationPanel
		public void actionPerformed (ActionEvent e){
			cancelationPanel.setVisible(false);
			mainPanel.setVisible(true);
		}
	}

	public class searchButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String arrivaltext=arrivalBox.getSelectedItem().toString();
			String departuretext=departureBox.getSelectedItem().toString();
			if(arrivaltext.equals(departuretext)){
				JOptionPane.showMessageDialog(null,"Departure and Arrival points can not be same!");
			}
			else{
				add(searchPanel);
				searchPanel.setVisible(true);
				sellingPanel.setVisible(false);
				String a ="Departure	Arrival	Hours	Empty Seats	Fee\n";
				File f=new File("Bus.txt");
				Scanner sf;
				try {
					sf = new Scanner(f);
					while(sf.hasNextLine()){
						String [] line;
						String x=sf.nextLine();
						line=x.split("\t");
						if(departureBox.getSelectedItem().toString().equals(line[0]) && 
								arrivalBox.getSelectedItem().toString().equals(line[1])){
							a=a+x+"\n";
						}	
					}
					textpanel.setText(a);	
					textpanel.setEditable(false);

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}				
		}
	}

	public class buyButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent e){

			String name = nameText.getText();
			String phoneNumber = phoneText.getText();
			String arrivaltext=arrivalBox.getSelectedItem().toString();
			String departuretext=departureBox.getSelectedItem().toString();
			String result="";
			String [] line = {}; 
			File f=new File("Bus.txt");
			Scanner sf;
			int Totalfee=0;
			boolean emptySeats = true;
			try {
				sf = new Scanner(f);
				while(sf.hasNextLine()){

					String x=sf.nextLine();
					line=x.split("\t");

					if(departuretext.equals(line[0]) && arrivaltext.equals(line[1]) &&
							line[2].equals(r1.getText()) && r1.isSelected()){

						int Seats = Integer.parseInt(line[3]);
						Totalfee = Integer.parseInt((String) numofSeats.getSelectedItem()) * Integer.parseInt(line[4]);

						if(Seats>=Integer.parseInt((String) numofSeats.getSelectedItem())){
							Seats-=Integer.parseInt((String) numofSeats.getSelectedItem());
							line[3]=Integer.toString(Seats);
						}
						else{
							JOptionPane.showMessageDialog(null,"Not enough empty seats");
							emptySeats=false;
						}
					}
					else if(departuretext.equals(line[0]) && arrivaltext.equals(line[1]) &&
							line[2].equals(r2.getText()) && r2.isSelected()){

						int Seats = Integer.parseInt(line[3]);
						Totalfee = Integer.parseInt((String) numofSeats.getSelectedItem()) * Integer.parseInt(line[4]);

						if(Seats>=Integer.parseInt((String) numofSeats.getSelectedItem())){
							Seats-=Integer.parseInt((String) numofSeats.getSelectedItem());
							line[3]=Integer.toString(Seats);
						}
						else{
							JOptionPane.showMessageDialog(null,"Not enough empty seats");
							emptySeats=false;
						}
					}
					else if(departuretext.equals(line[0]) && arrivaltext.equals(line[1]) &&
							line[2].equals(r3.getText()) && r3.isSelected()){

						int Seats = Integer.parseInt(line[3]);
						Totalfee = Integer.parseInt((String) numofSeats.getSelectedItem()) * Integer.parseInt(line[4]);
						if(Seats>=Integer.parseInt((String) numofSeats.getSelectedItem())){
							Seats-=Integer.parseInt((String) numofSeats.getSelectedItem());
							line[3]=Integer.toString(Seats);
						}
						else{
							JOptionPane.showMessageDialog(null,"Not enough empty seats");
							emptySeats=false;
						}
					}
					result += line[0]+"\t"+line[1]+"\t"+line[2]+"\t"+line[3]+"\t"+line[4]+"\n";
				}

				if(name.isEmpty() || phoneNumber.isEmpty()){
					JOptionPane.showMessageDialog(null, "Fill the Name and Phone Number");
				}

				FileWriter fw2=new FileWriter(f);
				PrintWriter pw2=new PrintWriter(fw2);
				pw2.write(result);
				pw2.close();

				if(!(nameText.getText().isEmpty()) && !(phoneText.getText().isEmpty()) && emptySeats){
					Random r=new Random();
					int tID=1+r.nextInt(1000000);				
					Customer cm1 =new Customer(name,phoneNumber,tID);
					cm1.writeTickets(name, phoneNumber, tID, departuretext, arrivaltext, r1.getText(),Totalfee);
				}
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}



	public class cancelButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent e){

			File f=new File("Tickets.txt");
			String result="";
			boolean find=false;
			try {
				Scanner sd = new Scanner(f);
				String x="";
				while(sd.hasNextLine()){

					x=sd.nextLine();
					String [] line = x.split("\t");

					if(!(ticketID.getText().isEmpty()) && ticketID.getText().equals(line[2])){
						JOptionPane.showMessageDialog(null, "Cancellation is success ");
						find=true;
						continue;//This continue for delete the informations about canceling ticket
					}

					result += x+"\n";	
				}

				if(!find){
					JOptionPane.showMessageDialog(null,"TicketID could not found!");
				}

				FileWriter fw2;
				try {
					fw2 = new FileWriter(f);
					PrintWriter pw2=new PrintWriter(fw2);
					pw2.write(result);
					pw2.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
