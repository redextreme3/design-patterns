package chat_bot_3000;

import java.util.ArrayList;
import java.util.List;

public class Chatroom implements ChatMediator {
	
	private List<User> users;
	private List<String> forbiddenWords;
	SingletonChatBot chatBotConnection;
	
	public Chatroom() 
	{
		this.users = new ArrayList<>();
		this.forbiddenWords = new ArrayList<>();
		forbiddenWords.add("cat");
	}

	@Override
	public void sendMessage(String message, User user) 
	{
		if(users.contains(user)) 
		{
			if(message == "addBot") 
			{
				addBot();
			}
			
			if(checkUserMessage(message, user)) 
			{
				return;
			}
			
			else 
			{
				for(User chatUser: this.users) 
				{
					// skipping the one who sends the message
					if(chatUser != user) 
					{
						chatUser.receiveMessage(message);
					}	
				}
			}
			
		}	
		
	}

	@Override
	public void addUser(User user) 
	{
		this.users.add(user);
	}

	@Override
	public void removeUser(User user) 
	{
		this.users.remove(user);
	}

	@Override
	public void addBot() 
	{
		chatBotConnection = SingletonChatBot.getInstance();
		chatBotConnection.postMessage("Connection established.");
		
	}
	
	private boolean checkUserMessage(String message, User user) 
	{
		if(chatBotConnection != null) 
		{
			boolean detectedBadWord = chatBotConnection.scanMessage(message, forbiddenWords);
			if(detectedBadWord) 
			{
				this.removeUser(user);
				chatBotConnection.postMessage(user.username + " has been removed from the chat for using a bad word.");
				return true;
			}
		}
		
		return false;
	}
	
	public List<User> getAllUsers() 
	{
		return users;
	}

}
