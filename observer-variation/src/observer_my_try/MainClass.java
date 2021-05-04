package observer_my_try;

public class MainClass {
	
	public static void main(String[] args) {
	
	Product phone = new Product("Samsung Galaxy S20 FE");
	
	Tracker mike = new Tracker("Mike");
	Tracker alex = new Tracker("Alex");
	Tracker john = new Tracker("John");
	
	phone.addObserver(mike);
	phone.addObserver(alex);
	phone.addObserver(john);
	
	phone.setMessage("Price decreased from 1000 USD to 880 USD for " + phone.getProductName());
	
	phone.setMessage("Limited stock for " + phone.getProductName());
	
	}

}
