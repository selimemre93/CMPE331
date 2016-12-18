import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Customer {

	
		private String Name;
		private String PhoneNumber;
		private int TicketID;
		
		public Customer() 
		{
			
		}
		public Customer(String Name, String PhoneNumber, int TicketID)
		{
			this.Name = Name;
			this.PhoneNumber = PhoneNumber;
			this.TicketID=TicketID;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			this.Name = name;
		}
		public String getPhoneNumber() {
			return PhoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.PhoneNumber = phoneNumber;
		}
		public int getTicketID(){
			return TicketID;
		}
		public void setTicketID(int TicketID){
			this.TicketID=TicketID;
		}
		
		public void writeTickets(String name,String phoneNumber,int tID,String departuretext,String arrivaltext,String r1,int Totalfee) throws IOException{
			JOptionPane.showMessageDialog(null, "Accepted");
			File tickets = new File("Tickets.txt");
			FileWriter fw;
			fw = new FileWriter(tickets,true);
			PrintWriter pw=new PrintWriter(fw);
			pw.println(name+"\t"+phoneNumber+"\t"+tID+"\t"+departuretext+"\t"+arrivaltext+"\t"+r1+"\t"+Totalfee);
			pw.close();

			JOptionPane.showMessageDialog(null, "Name : " +name+ "\n" + "Phone Number : " +phoneNumber+ "\n"+"Ticket ID : " + tID + "\n" + "Departure : "
					+departuretext+ "\n" + "Arrival : "+ arrivaltext+ "\n" + "Hour : "+ r1+ "\n"+"Fee : "+Totalfee+" TL");
			
		}
		
}
