package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatbotViewer;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;

/**
 * Class ChatController.
 * @author bmof0507
 *
 */
public class ChatController
/**
 * ChatController data members (Chatbot, ChatbotViewer, and ChatFrame).
 */
{
	private Chatbot stupidBot;
	private ChatbotViewer display;
	private ChatFrame appFrame;
	private CTECTwitter twitterBot;
	
	/**
	 * stupidBot and appFrame are defined. 
	 */
	public ChatController()
	{
		stupidBot = new Chatbot("Automated intelligence conversation machine");
		twitterBot = new CTECTwitter(this);
		appFrame = new ChatFrame(this);
		//display = new ChatBotViewer(this);
	}
	
	/**
	 * Start Method.
	 */
	public void start()
	{
		
	}
	
	
	/**
	 * Method useChatbotCheckers assigns answers with a sequence of if's.
	 * If the users input falls into a predetermined topic, the chatbot will recognize and answer to it.
	 * @param input
	 * @return
	 */
	public String useChatbotCheckers(String input)

	{
		String checkedInput = "";
		if(!stupidBot.quitChecker(input))
		{
			if(stupidBot.memeChecker(input))
			{
				checkedInput += "\nYou like memes!? Tell me more.\n";
				
			if(stupidBot.politicalTopicChecker(input))	
			{
				checkedInput += "\nPolitics are fun to talk about!\n";
			}
			
			if(stupidBot.keyboardMashChecker(input))
			{
				checkedInput += "\nStop hitting your keyboard, it did nothing to you\n";
			}
			
			if(stupidBot.inputHTMLChecker(input))
			{
				checkedInput += "\nThis is a ChatBot, not a web viewer. Go back to Google\n";
			}
			
			if(stupidBot.twitterChecker(input))
			{
				checkedInput += "\nYou're on the wrong app my friend. This isnt social media.\n";
			}
			
			if(stupidBot.quitChecker(input))
			{
				checkedInput += "\nYou're leaving me now? When I need you the most?\n";
			}
			
			}
			if(stupidBot.contentChecker(input))
			{
				checkedInput += "\nYou have found my secret topic!\n";
			}
			
			if(checkedInput.length() == 0)
			{
				checkedInput = "I have no idea what " + input + " is.";
			}
			
			int canBeRandom = (int) (Math.random() * 7);
			if(canBeRandom % 7 == 0)
			{
				checkedInput += randomTopicGenerator();
			}
		}
		else
	{
		display.displayMessage("Thanks for chatting!");
		System.exit(0);
	}
		return checkedInput;
	}
	
	/**
	 * Method randomTopicGenerator will ask random topic questions to keep the conversation going.
	 * The method will ask a random question from the list at random times.
	 * @return
	 */
	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);
		
		switch(random)
		{
		case 0:
			randomTopic = "Have you heard Tory Lanez version of Controller (by Drake)? 🙏🙌😩";
			break;
		case 1:
			randomTopic = "I'm in the mood for some Mexican food.";
			break;
		case 2:
			randomTopic = "I can't wait to become a real person like you.";
			break;
		case 3:
			randomTopic = "Can you guess my secret topic? Hint** It was a historical point.";
			break;	
		case 4:
			randomTopic = "Fam.. don't look behind you.";
			break;	
		case 5:
			randomTopic = "What do you think about Harambe?";
			break;
		case 6:
			randomTopic = "Trump or nah?";
			break;	
		default:
			randomTopic = "If you're seeing this, something went terribly wrong... 😬 ";
			break;
		}
		
		return randomTopic;
	}

	public void handleErrors(Exception currentException)
	{
		display.displayMessage("an error has occured. Details provided next.");
		display.displayMessage(currentException.getMessage());
	}
	public void useTwitter(String text)
	{
		twitterBot.sendTweet(text);
	}
	
	public String searchTwitterUser(String userNameToSearch)
	{
		String searchResults = "";
		searchResults = "The most popular word by user: " + userNameToSearch + ", is";
		searchResults += twitterBot.getMostCommonWord(userNameToSearch);
		return searchResults;
	}
	
	/**
	 * Method getBaseFrame returns appFrame.
	 * @return
	 */
	public ChatFrame getBaseFrame()
	{
		return appFrame;
	}
	
	/**
	 * Method getChatbot returns stupidBot.
	 * @return
	 */
	public Chatbot getChatbot()
	{
		return stupidBot;
	}
	
	/**
	 * Method communicateWithChatbot returns botText and assigns the chatbot to answer " " when this method is triggered. 
	 * @param userText
	 * @return
	 */
	public String communicateWithChatbot(String userText)
	{
		String botText = "";
		
		return botText;
	}
}
