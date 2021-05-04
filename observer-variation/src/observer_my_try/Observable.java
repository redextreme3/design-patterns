package observer_my_try;

public interface Observable {
	
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
	
	String getUpdate();

}
