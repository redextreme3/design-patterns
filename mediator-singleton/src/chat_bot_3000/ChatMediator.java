package chat_bot_3000;

import java.util.List;

public interface ChatMediator {
	
	void sendMessage(String message, User user);
	void addUser(User user);
	void removeUser(User user);
	void addBot();
	List<User> getAllUsers();
	
}
