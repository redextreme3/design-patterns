package chat_bot_3000;

import java.util.List;

public class SingletonChatBot {
	
	private static SingletonChatBot instance;
	
	private SingletonChatBot() 
	{
		
	}
	
	public static SingletonChatBot getInstance() 
	{
		if (instance == null) 
		{
			instance = new SingletonChatBot();
		}
		
		return instance;
	}
	
	public void postMessage(String message) 
	{
		System.out.println("ChatBot3000: " + message);
	}
	
	public boolean scanMessage(String message, List<String> forbidden_words) 
	{
		for (String badWord: forbidden_words)
		{
			if(message.contains(badWord)) 
			{
				instance.postMessage("'" + badWord + "' is a forbidden word in this chat.");
				return true;
			}
		}
		
		return false;
	}

}
