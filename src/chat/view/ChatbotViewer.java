package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Class ChatbotViewer.
 * @author bmof0507
 *
 */
public class ChatbotViewer
{
	/**
	 * ChatbotViewer data members (windowMessage and chatIcon).
	 */
		private String windowMessage;
		private ImageIcon chatIcon;
	
		/**
		 * Method ChatbotViewer assigns message in window and icon for the chatbot. (not used)
		 */
	public ChatbotViewer()
	{
		windowMessage = "Chatbot AICM";
		chatIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
	}
	
	/**
	 * Method collectResponse assigns certain aspects of the chatbot to specific areas of the program.
	 * @param question
	 * @return
	 */
	public String collectResponse(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type here please").toString();
		
		return response;
	}
	
	/**
	 * Method displayMessage displays the chatbots message.
	 * @param message
	 */
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
	}
	
	/**
	 * Method collectUserData collects the userInput and restates it.
	 * @param question
	 * @return
	 */
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null, question);
		
		return response;
	}
}
