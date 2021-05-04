package chat_bot_3000;

public class ChatUser extends User {

	public ChatUser(ChatMediator mediator, String name) {
		super(mediator, name);
		mediator.addUser(this);
	}

	@Override
	public void sendMessage(String message) 
	{
		if(mediator.getAllUsers().contains(this)) 
		{
			System.out.println(this.username + " sent a message: " + message);
			this.mediator.sendMessage(message, this);
		}
		else 
		{
			System.out.println("User with name '" + this.username + "' not found.");
		}
			
	}

	@Override
	public void receiveMessage(String message) 
	{
		System.out.println(this.username + " received a message: " + message);
	}

}
