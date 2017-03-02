package chat.tests;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.controller.ChatController;
import chat.view.ChatPanel;

public class ChatPanelTest
{
	private ChatPanel basePanel;
	
	@Before
	public void setUp() throws Exception
	{
		basePanel = new ChatPanel(new ChatController());
	}

	@After
	public void tearDown() throws Exception
	{
		basePanel = null;
	}
	
	@Test
	public void testSetupPanel()
	{
		assertTrue("Incorrect layout manager specified", basePanel.getLayout() instanceof javax.swing.SpringLayout);
		assertTrue("Minimum component amount not met", basePanel.getComponents().length >= 4);
		
		for(Component currentGUIComponent : basePanel.getComponents())
		{
		 	if(currentGUIComponent instanceof JTextArea)
			{
				assertFalse("Text area should not be enabled", currentGUIComponent.isEnabled());
				assertFalse("Text area should not be editable", ((JTextArea) currentGUIComponent).isEditable());
			}
		}
		
	}
	
	@Test
	public void testSetupListeners()
	{
		for(Component currentGUIComponent : basePanel.getComponents())
		{
			if(currentGUIComponent instanceof JButton)
			{
				assertNotNull("Listener not installed for JButton",((JButton) currentGUIComponent).getActionListeners()[0]);
				assertTrue("Correct type of listener not installed", ((JButton) currentGUIComponent).getActionListeners()[0] instanceof ActionListener);
			}
		}
	}
}
