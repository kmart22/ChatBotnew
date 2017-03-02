package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chat.view.*;
import chat.controller.*;

public class ChatFrameTest
{
	private ChatFrame baseFrame;

	@Before
	public void setUp() throws Exception
	{
		baseFrame = new ChatFrame(new ChatController());
	}

	@After
	public void tearDown() throws Exception
	{
		baseFrame = null;
	}

	@Test
	public void testChatFrame()
	{
		assertNotNull("Constructor not initialized",baseFrame);
		
	}
	
	@Test
	public void testSetupFrame()
	{
		assertNotEquals("Title not specified", baseFrame.getTitle(), "");
		assertTrue("Frame visibility incorrectly set",baseFrame.isVisible());
		assertTrue("Incorrect base panel type",baseFrame.getContentPane() instanceof ChatPanel);
	}

}
