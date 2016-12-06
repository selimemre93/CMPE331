
public class Customer {

	
		private String Name;
		private int PhoneNumber;
		private String Address;
		
		public Customer() 
		{
			
		}
		public Customer(String Name, int PhoneNumber, String Address)
		{
			this.Name = Name;
			this.PhoneNumber = PhoneNumber;
			this.Address = Address;
			
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			this.Name = name;
		}
		public int getPhoneNumber() {
			return PhoneNumber;
		}
		public void setPhoneNumber(int phoneNumber) {
			this.PhoneNumber = phoneNumber;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			this.Address = address;
		}
		
		
}
