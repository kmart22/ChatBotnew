package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatController;
import java.awt.Dimension;

/**
 * Class ChatFrame.
 * @author bmof0507
 *
 */
public class ChatFrame extends JFrame
{
	/**
	 * ChatFrame data members.
	 */
	private ChatController baseController;
	private ChatPanel appPanel;
	
	/**
	 * Method ChatFrame assigns baseController and ChatPanel.
	 * @param baseController
	 */
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * Method setupFrame sets up frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("ChatBot");
		this.setSize(new Dimension(450, 300));
		this.setVisible(true);;
	}
}
