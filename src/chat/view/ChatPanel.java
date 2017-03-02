package chat.view;

import javax.swing.*;
import java.awt.Color;
import chat.controller.ChatController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class ChatPanel (inherits JPanel)
 * @author bmof0507
 *
 */
public class ChatPanel extends JPanel
{
	/**
	 * ChatPanel data members.
	 */
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton postButton;
	private JButton searchButton;
	private JScrollPane chatPane;
	private JLabel chatTitle;
	
	/**
	 * Method ChatPanel sets up display.
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5,25);
		chatField = new JTextField(25);
		chatButton = new JButton("Send it to the bot");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		postButton = new JButton("Post to Twitter");
		searchButton = new JButton("Search Twitter");
		chatTitle = new JLabel("Chatbot");
		chatPane = new JScrollPane();
	
		
		
		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Method setupChatDisplay sets up the chat display.
	 */
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setLineWrap(true);
		chatPane.setViewportView(chatDisplay);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	/**
	 * Method setupPanel sets up the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(postButton);
		this.add(searchButton);
//		this.add(chatDisplay);
		this.add(chatPane);
		this.add(chatField);
		this.add(chatTitle);
	}
	
	/**
	 * Method setupLayout holds useless information consisting of positioning information.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 30, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 9, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 134, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTitle, 197, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTitle, -6, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, -365, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, loadButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -6, SpringLayout.NORTH, loadButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, loadButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, postButton, 0, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, postButton, 213, SpringLayout.EAST, saveButton);
		baseLayout.putConstraint(SpringLayout.EAST, postButton, 0, SpringLayout.EAST, searchButton);
		baseLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, loadButton);
		baseLayout.putConstraint(SpringLayout.WEST, searchButton, 317, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, searchButton, -10, SpringLayout.EAST, this);
	}
	
	/**
	 * Method setupListeners watches for ActionEvents and ActionListeners.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String personWords = chatField.getText();
				String chatbotResponse = baseController.useChatbotCheckers(personWords);
				String currentText = chatDisplay.getText();
				
				chatDisplay.setText(currentText + "\nYou said: " + personWords + "\n"+ "Chatbot says: " + chatbotResponse + "\n");
				chatDisplay.setCaretPosition(0);
				chatField.setText("");
			}
		});
	}
}
