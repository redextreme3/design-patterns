package observer_my_try;

import java.util.ArrayList;
import java.util.List;

public class Product implements Observable{
	
	private List<Observer> trackers;
	private String message;
	private String productName;
	
	public Product(String productName) 
	{
		this.trackers = new ArrayList<>();
		this.productName = productName;
	}

	@Override
	public void addObserver(Observer observer) {
		this.trackers.add(observer);
		observer.setProduct(this);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.trackers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		trackers.forEach(observer -> observer.update());;
	}
	
	public void setMessage(String message) {
		this.message = message;
		this.notifyObservers();
	}

	@Override
	public String getUpdate() {
		return this.message;
	}
	
	public String getProductName() {
		return this.productName;
	}

}
