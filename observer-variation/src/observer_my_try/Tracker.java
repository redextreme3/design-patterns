package observer_my_try;

public class Tracker implements Observer{
	
	private Observable message;
	private String username;
	
	public Tracker(String username)  {
		this.username = username;
	}

	@Override
	public void update() {
		
		if(this.message == null) {
			System.out.println(this.getUsername() + " has no tracked products.");
			return;
		}
		
		String newMessage = this.message.getUpdate();
		System.out.println(this.getUsername() + " received a new message: " + newMessage);
	}

	@Override
	public void setProduct(Observable product) {
		this.message = product;
	}
	
	public String getUsername() {
		return username;
	}

}
