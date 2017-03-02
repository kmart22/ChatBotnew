package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chat.model.Chatbot;

/**
 * Class designed for testing the Chatbot object with JUnit.
 * 
 * @author Cody Henrichsen
 * @version 1.5
 */
public class ChatbotTest
{
	private Chatbot sampleBot;
	private String userName;

	@Before
	public void setUp() throws Exception
	{
		userName = "test";
		sampleBot = new Chatbot(userName);
	}

	@After
	public void tearDown() throws Exception
	{
		userName = null;
		sampleBot = null;
	}

	@Test
	public void testChatbot()
	{
		assertNotNull("The memesList is not initialized", sampleBot.getMemesList());
		assertNotNull("The politicalTopicsList is not initialized", sampleBot.getPoliticalTopicList());
		assertSame("The Chatbot’s username is not being assigned", userName, sampleBot.getUserName());
	}

	@Test
	public void testGetUserName()
	{
		assertSame("Getters work", userName, sampleBot.getUserName());
	}

	@Test
	public void testGetContent()
	{
		String content = "topic area of interest";
		sampleBot.setContent(content);
		assertSame("Setters and Getters work", content, sampleBot.getContent());
	}

	@Test
	public void testGetMemesList()
	{
		assertNotNull("Constructor functions and getters work again", sampleBot.getMemesList());
	}

	@Test
	public void testGetPoliticalTopicList()
	{
		assertNotNull("Constructors and Getters still work in Java", sampleBot.getPoliticalTopicList());
	}

	@Test
	public void testSetContent()
	{
		String oldContent = sampleBot.getContent();
		String content = "some other content";
		sampleBot.setContent(content);
		assertNotSame("Changed values", oldContent, sampleBot.getContent());
		assertSame("Setters work", content, sampleBot.getContent());
	}

	@Test
	public void testLengthChecker()
	{
		assertFalse("incorrect zero length check", sampleBot.lengthChecker(""));
		assertFalse("incorrect null check", sampleBot.lengthChecker(null));
		assertTrue("incorrect length check", sampleBot.lengthChecker("        "));
	}

	@Test
	public void testContentChecker()
	{
		String content = "some words";
		sampleBot.setContent(content);
		assertFalse("Check blank failed", sampleBot.contentChecker(" "));
		assertFalse("Check partial failed", sampleBot.contentChecker("words"));
		assertFalse("Check partial failed", sampleBot.contentChecker("some"));
		assertTrue("Check match failed", sampleBot.contentChecker(content));
		assertTrue("Check match plus failed", sampleBot.contentChecker("content " + content));
		assertTrue("Opposite check match failed", sampleBot.contentChecker(content + " other content"));
	}

	@Test
	public void testBuildMemesList()
	{
		assertTrue("MemeList Size check", sampleBot.getMemesList().size() > 17);
		assertTrue("Meme Topic check", sampleBot.getMemesList().contains("doge"));
		assertFalse("Meme Topic check", sampleBot.getMemesList().contains("dog"));
		assertTrue("Meme Topic check", sampleBot.getMemesList().contains("cute animals"));
		assertTrue("Meme Topic check", sampleBot.getMemesList().contains("cute animals"));
		assertTrue("Meme Topic check", sampleBot.getMemesList().contains("grumpy cat"));
		assertTrue("Meme Topic check", sampleBot.getMemesList().contains("dat boi"));
		assertTrue("Meme Topic check", sampleBot.getMemesList().contains("willy wonka"));
		assertTrue("Meme Topic check", sampleBot.getMemesList().contains("harambe"));
		assertTrue("Meme Topic check", sampleBot.getMemesList().contains("john cena"));

	}

	@Test
	public void testBuildPoliticalTopicList()
	{
		assertTrue("PoliticalTopicList Size check", sampleBot.getPoliticalTopicList().size() >= 18);
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("Democrat"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("Republican"));
		assertFalse("Political Topic check - wrong date", sampleBot.getPoliticalTopicList().contains("11/4/16"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("11/8/16"));
		assertFalse("Political Topic check - case", sampleBot.getPoliticalTopicList().contains("republican"));
		assertFalse("Political Topic check - case", sampleBot.getPoliticalTopicList().contains("democrat"));
		assertTrue("Topic check", sampleBot.getPoliticalTopicList().contains("liberal"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("conservative"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("Clinton"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("Trump"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("Kaine"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("Pence"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("Stein"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("Johnson"));
		assertTrue("Political Topic check", sampleBot.getPoliticalTopicList().contains("election"));

	}

	@Test
	public void testKeyboardMashChecker()
	{
		assertFalse("Mash incorrectly detected", sampleBot.keyboardMashChecker("S.D.F."));
		assertFalse("Mash incorrectly detected", sampleBot.keyboardMashChecker("derf"));
		assertTrue("Keyboard mashing not detected", sampleBot.keyboardMashChecker("sdf"));
		assertTrue("Keyboard mashing not detected", sampleBot.keyboardMashChecker("dfg"));
		assertTrue("Keyboard mashing not detected", sampleBot.keyboardMashChecker("cvb"));
		assertTrue("Keyboard mashing not detected", sampleBot.keyboardMashChecker(",./"));
	}

	@Test
	public void testPoliticalTopicChecker()
	{
		assertTrue("Incorrect Political Topic check", sampleBot.politicalTopicChecker("Democrat"));
		assertTrue("Incorrect Political Topic check", sampleBot.politicalTopicChecker("Republican"));
		assertTrue("Incorrect Political Topic check", sampleBot.politicalTopicChecker("11/8/16"));
		assertFalse("Incorrect Political Topic check - date", sampleBot.politicalTopicChecker("11/8/15"));
		assertFalse("Incorrect Political Topic check - case", sampleBot.politicalTopicChecker("trump"));
		assertTrue("Incorrect Political Topic check", sampleBot.politicalTopicChecker("Trump"));
		assertTrue("Incorrect Political Topic check", sampleBot.politicalTopicChecker("Hillary"));
		assertTrue("Incorrect Political Topic check", sampleBot.politicalTopicChecker("Clinton"));
		assertTrue("Incorrect Political Topic check", sampleBot.politicalTopicChecker("Stein"));
		assertTrue("Incorrect Political Topic check", sampleBot.politicalTopicChecker("Johnson"));
	}

	@Test
	public void testMemeChecker()
	{
		assertTrue("Incorrect meme Topic check", sampleBot.memeChecker("doge"));
		assertTrue("Incorrect meme Topic check", sampleBot.memeChecker("cute animals"));
		assertTrue("Incorrect meme Topic check", sampleBot.memeChecker("grumpy cat"));
		assertTrue("Incorrect meme Topic check", sampleBot.memeChecker("dat boi"));
		assertFalse("Incorrect meme Topic check", sampleBot.memeChecker("dat boy"));
		assertTrue("Incorrect meme Topic check", sampleBot.memeChecker("willy wonka"));
		assertTrue("Incorrect meme Topic check", sampleBot.memeChecker("harambe"));
		assertFalse("Incorrect meme Topic check", sampleBot.memeChecker("ambe"));
		assertTrue("Incorrect meme Topic check", sampleBot.memeChecker("john cena"));
		assertFalse("Incorrect meme Topic check", sampleBot.memeChecker("john"));
	}

	@Test
	public void testInputHTMLChecker()
	{
		assertFalse("Invalid tag fail", sampleBot.inputHTMLChecker("<>"));
		assertFalse("Invalid tag fail", sampleBot.inputHTMLChecker("< >"));
		assertTrue("Valid tag fail", sampleBot.inputHTMLChecker("<B>  </B>"));
		assertFalse("Incomplete tag fail - closing tag not found", sampleBot.inputHTMLChecker("<B>  "));
		assertTrue("Valid tag fail", sampleBot.inputHTMLChecker("<I> sdadas </i>"));
		assertTrue("Valid tag fail - no closing P needed", sampleBot.inputHTMLChecker("<P>"));
		assertTrue("Valid tag fail", sampleBot.inputHTMLChecker("<A HREF=\"sdfs.html\"> </a>"));
		assertFalse("Incomplete tag fail - no = for the linked file", sampleBot.inputHTMLChecker("<A HREF> </a>"));
	}

	@Test
	public void testTwitterChecker()
	{
		assertFalse("Empty twitter fail", sampleBot.twitterChecker(" "));
		assertTrue("Hashtag detect fail", sampleBot.twitterChecker("#dw35 f"));
		assertFalse("Empty hashtag fail", sampleBot.twitterChecker(" sdfsd # "));
		assertTrue("Twitter user detect fail", sampleBot.twitterChecker("@d4d sretsf "));
		assertFalse("Empty user fail", sampleBot.twitterChecker(" sdfsd @ "));
	}

	@Test
	public void testQuitChecker()
	{
		assertFalse("False positive", sampleBot.quitChecker("exit"));
		assertTrue("False negative", sampleBot.quitChecker("quit"));
	}
}
