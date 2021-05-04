package chat_bot_3000;

public class Main {

	public static void main(String[] args) {
		
		ChatMediator catsChat = new Chatroom();
		
		User garfield = new ChatUser(catsChat, "Garfield");
		User tom = new ChatUser(catsChat, "Tom");
		User azrael = new ChatUser(catsChat, "Azrael");
		
		garfield.sendMessage("I'm a cat that loves lasagna.");
		
		tom.sendMessage("addBot");
		
		azrael.sendMessage("Meow! A fellow cat!");
		
		azrael.sendMessage("Help me find the smurfs!");
		
		
		
		

	}

}
